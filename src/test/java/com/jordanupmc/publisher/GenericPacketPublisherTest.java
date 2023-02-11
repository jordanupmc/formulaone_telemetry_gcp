package com.jordanupmc.publisher;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.pubsub.v1.*;
import com.google.pubsub.v1.*;
import com.jordanupmc.core.packet.Packet;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.avro.generic.GenericContainer;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static com.google.common.base.MoreObjects.firstNonNull;
import static org.assertj.core.api.Assertions.assertThat;

/*
 * Require pubsub emulator
 * gcloud beta emulators pubsub start --project=$PUBSUB_PROJECT_ID
 */
abstract class GenericPacketPublisherTest<P extends Packet, M extends GenericContainer> {

    private final GenericPacketPublisher<P, M> publisher;
    private final Topic topic;
    private final Class<M> messageClass;

    public GenericPacketPublisherTest(GenericPacketPublisher<P, M> publisher, Class<M> messageClass) {
        this.publisher = publisher;
        this.messageClass = messageClass;
        this.topic = publisher.getTopic();
    }

    protected abstract P getMessage();

    protected abstract Consumer<M> assertMessage();

    @Test
    void should_publish_and_receive_message_expected_message() throws Exception {
        String hostport = firstNonNull(System.getenv("PUBSUB_EMULATOR_HOST"), "localhost:8085");
        ManagedChannel channel = ManagedChannelBuilder.forTarget(hostport).usePlaintext().build();

        var messageFuture = new CompletableFuture<M>();

        Subscriber subscriber = initPubSubEnvWithSubscriber(channel, messageFuture);

        publisher.publish(getMessage());

        try {
            subscriber.startAsync().awaitRunning();
            var message = messageFuture.get(5, TimeUnit.SECONDS);
            assertThat(message).satisfies(assertMessage());
        } finally {
            channel.shutdown();
            subscriber.stopAsync();
        }
    }

    private Subscriber initPubSubEnvWithSubscriber(ManagedChannel channel,
                                                   CompletableFuture<M> messageFuture) throws IOException {
        TransportChannelProvider channelProvider =
                FixedTransportChannelProvider.create(GrpcTransportChannel.create(channel));
        CredentialsProvider credentialsProvider = NoCredentialsProvider.create();
        TopicName topicName = PubSubPublisherFactory.getPublisher(topic).getTopicName();
        createTopic(channelProvider, credentialsProvider, topicName);
        createSubscription(channelProvider, credentialsProvider, topicName, SubscriptionName.of(topicName.getProject(), topicName.getTopic()));

        return createSubscriber(messageFuture, channelProvider, credentialsProvider, topicName);
    }

    private Subscriber createSubscriber(CompletableFuture<M> messageFuture,
                                        TransportChannelProvider channelProvider,
                                        CredentialsProvider credentialsProvider,
                                        TopicName topicName) {
        ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(topicName.getProject(), topicName.getTopic());
        MessageReceiver receiver = (var message1, var consumer) -> {
            consumer.ack();
            messageFuture.complete(deserialize(message1));
        };

        return Subscriber.newBuilder(subscriptionName, receiver)
                .setChannelProvider(channelProvider)
                .setCredentialsProvider(credentialsProvider)
                .build();
    }

    private M deserialize(PubsubMessage message) {
        var datumReader = new SpecificDatumReader<>(messageClass);
        Decoder decoder = DecoderFactory.get()
                .binaryDecoder(message.getData().toByteArray(), null);
        try {
            return datumReader.read(null, decoder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createTopic(TransportChannelProvider channelProvider,
                                    CredentialsProvider credentialsProvider,
                                    TopicName topicName) throws IOException {
        try (var topicClient =
                     TopicAdminClient.create(TopicAdminSettings.newBuilder()
                             .setTransportChannelProvider(channelProvider)
                             .setCredentialsProvider(credentialsProvider)
                             .build())) {
            topicClient.createTopic(topicName);
        } catch (AlreadyExistsException ignored) {
        }
    }

    private static void createSubscription(
            TransportChannelProvider channelProvider,
            CredentialsProvider credentialsProvider,
            TopicName topicName,
            SubscriptionName subscriptionName) throws IOException {
        try (var subscriptionAdminClient =
                     SubscriptionAdminClient.create(SubscriptionAdminSettings.newBuilder()
                             .setTransportChannelProvider(channelProvider)
                             .setCredentialsProvider(credentialsProvider)
                             .build())) {
            subscriptionAdminClient.createSubscription(subscriptionName, topicName, PushConfig.getDefaultInstance(), 100);
        } catch (AlreadyExistsException ignored) {
        }
    }

}