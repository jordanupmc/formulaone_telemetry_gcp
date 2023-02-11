package com.jordanupmc.publisher;

import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.jordanupmc.core.packet.Packet;
import com.jordanupmc.publisher.dto.PacketHeader;
import org.apache.avro.generic.GenericContainer;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;

public abstract class GenericPacketPublisher<P extends Packet, M extends GenericContainer> implements PacketPublisher<P> {
    protected final Topic topic;

    public GenericPacketPublisher(Topic topic) {
        this.topic = topic;
    }

    protected abstract M toAvroMessage(P packet);

    public Topic getTopic() {
        return topic;
    }

    @Override
    public Future<String> publish(P packet) throws IOException {
        M avroMessage = toAvroMessage(packet);
        var pubsubMessage = PubsubMessage.newBuilder()
                .setData(serialize(avroMessage))
                .build();
        return PubSubPublisherFactory.getPublisher(topic).publish(pubsubMessage);
    }

    protected ByteString serialize(M message) throws IOException {
        try (ByteArrayOutputStream byteStream = new ByteArrayOutputStream()) {
            DatumWriter<M> datumWriter = new SpecificDatumWriter<>(message.getSchema());
            Encoder encoder = EncoderFactory.get().binaryEncoder(byteStream, null);
            datumWriter.write(message, encoder);
            encoder.flush();
            return ByteString.copyFrom(byteStream.toByteArray());
        }
    }

    protected List<Integer> mapToListInteger(List<Short> shorts) {
        return shorts.stream()
                .map(x -> (int) x)
                .toList();
    }

    protected com.jordanupmc.publisher.dto.PacketId mapPacketId(com.jordanupmc.core.packet.PacketId packetId) {
        return switch (packetId) {
            case MOTION -> com.jordanupmc.publisher.dto.PacketId.MOTION;
            case SESSION -> com.jordanupmc.publisher.dto.PacketId.SESSION;
            case LAP_DATA -> com.jordanupmc.publisher.dto.PacketId.LAP_DATA;
            case EVENT -> com.jordanupmc.publisher.dto.PacketId.EVENT;
            case PARTICIPANTS -> com.jordanupmc.publisher.dto.PacketId.PARTICIPANTS;
            case CAR_SETUPS -> com.jordanupmc.publisher.dto.PacketId.CAR_SETUPS;
            case CAR_TELEMETRY -> com.jordanupmc.publisher.dto.PacketId.CAR_TELEMETRY;
            case CAR_STATUS -> com.jordanupmc.publisher.dto.PacketId.CAR_STATUS;
            case FINAL_CLASSIFICATION -> com.jordanupmc.publisher.dto.PacketId.FINAL_CLASSIFICATION;
            case LOBBY_INFO -> com.jordanupmc.publisher.dto.PacketId.LOBBY_INFO;
            case CAR_DAMAGE -> com.jordanupmc.publisher.dto.PacketId.CAR_DAMAGE;
            case SESSION_HISTORY -> com.jordanupmc.publisher.dto.PacketId.SESSION_HISTORY;
        };
    }

    protected PacketHeader toAvroMessage(com.jordanupmc.core.packet.PacketHeader packet) {
        return PacketHeader.newBuilder()
                .setPacketFormat(packet.packetFormat())
                .setGameMajorVersion(packet.gameMajorVersion())
                .setGameMinorVersion(packet.gameMinorVersion())
                .setPacketVersion(packet.packetVersion())
                .setPacketId(mapPacketId(packet.packetId()))
                .setSessionUID(packet.sessionUID())
                .setSessionTime(packet.sessionTime())
                .setFrameIdentifier(packet.frameIdentifier())
                .setPlayerCarIndex(packet.playerCarIndex())
                .setSecondaryPlayerCarIndex(packet.secondaryPlayerCarIndex())
                .build();
    }
}
