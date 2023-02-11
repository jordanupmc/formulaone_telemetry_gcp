package com.jordanupmc.udpserver;

import com.jordanupmc.core.packet.PacketCarTelemetryData;
import com.jordanupmc.core.packet.PacketMotionData;
import com.jordanupmc.publisher.PacketPublisherFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

import static com.jordanupmc.core.packet.PacketMapper.mapToPacket;

public class UdpServer implements Server {
    public static void main(String[] args) {
        try (var datagramChannel = Server.startServer(HOSTNAME, PORT)) {
            while (true) {
                handleDatagram(datagramChannel);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void handleDatagram(DatagramChannel server) throws IOException {
        ByteBuffer buffer = Server.receiveDatagram(server, BUFFER_BYTES_CAPACITY);
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