package com.jordanupmc.udpserver;

import com.jordanupmc.core.Packet.PacketCarTelemetryData;
import com.jordanupmc.core.Packet.PacketMotionData;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

import static com.jordanupmc.core.Packet.PacketMapper.mapToPacket;

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
                    System.out.println("F1 2020 client sent: world position X = " +
                            motionData.carMotionData().get(motionData.header().playerCarIndex()).worldPositionX() + " playerIndex = " + motionData.header().playerCarIndex());
            case PacketCarTelemetryData telemetryData ->
                    System.out.println("F1 2020 client sent: speed = " + telemetryData.carTelem().speed() +
                            " playerIndex = " + telemetryData.header().playerCarIndex());
        }
    }
}