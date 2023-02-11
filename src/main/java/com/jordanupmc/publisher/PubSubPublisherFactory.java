package com.jordanupmc.publisher;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.pubsub.v1.TopicName;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.google.common.base.MoreObjects.firstNonNull;

class PubSubPublisherFactory {

    private static final Map<Topic, Publisher> publishers = new ConcurrentHashMap<>();

    static Publisher getPublisher(Topic topic) {
        return publishers.computeIfAbsent(topic, PubSubPublisherFactory::createPublisher);
    }

    private static Publisher createPublisher(Topic topic) {
        TopicName topicName = TopicName.of(firstNonNull(System.getenv("GCLOUD_PROJECT"), "helium-f1de7"), topic.getTopicId());
        String hostport = firstNonNull(System.getenv("PUBSUB_EMULATOR_HOST"), "localhost:8085");
        try {
            var publisherBuilder = Publisher.newBuilder(topicName);
            if (isEmulatorMode(hostport)) {
                ManagedChannel channel = ManagedChannelBuilder
                        .forTarget(hostport)
                        .usePlaintext()
                        .build();

                publisherBuilder
                        .setChannelProvider(FixedTransportChannelProvider.create(GrpcTransportChannel.create(channel)))
                        .setCredentialsProvider(NoCredentialsProvider.create());

            }
            return publisherBuilder.build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean isEmulatorMode(String hostport) {
        return hostport != null && !hostport.isEmpty();
    }
}
