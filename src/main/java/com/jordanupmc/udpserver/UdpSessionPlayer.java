package com.jordanupmc.udpserver;

import com.jordanupmc.core.packet.PacketCarTelemetryData;
import com.jordanupmc.core.packet.PacketMotionData;
import com.jordanupmc.publisher.PacketPublisherFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static com.jordanupmc.core.packet.PacketMapper.mapToPacket;
import static com.jordanupmc.udpserver.Server.BUFFER_BYTES_CAPACITY;

public class UdpSessionPlayer {
    private static final String FILE_NAME = "udp_record/udp_record_qualif_silverstone";

    public static void main(String[] args) {
        try {
            replaySession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void replaySession() throws IOException {
        URL resource = UdpSessionPlayer.class.getClassLoader().getResource(UdpSessionPlayer.FILE_NAME);
        try (var fos = new FileInputStream(resource.getFile())) {
            ByteBuffer buffer = initBuffer();
            while (fos.read(buffer.array()) > 0) {
                buffer.position(0);
                handlePacket(buffer);
            }
        }
    }

    private static ByteBuffer initBuffer() {
        return ByteBuffer
                .allocate(BUFFER_BYTES_CAPACITY)
                .order(ByteOrder.LITTLE_ENDIAN);
    }

    private static void handlePacket(ByteBuffer buffer) throws IOException {
        switch (mapToPacket(buffer)) {
            case null -> {
            }
            case PacketMotionData motionData ->
                    PacketPublisherFactory.getPacketPublisher(motionData).publish(motionData);
            case PacketCarTelemetryData telemetryData ->
                    PacketPublisherFactory.getPacketPublisher(telemetryData).publish(telemetryData);
        }
    }
}
