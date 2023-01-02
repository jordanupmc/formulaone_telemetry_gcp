package com.jordanupmc.core.Packet;

import java.nio.ByteBuffer;

public class PacketMapper {
    private PacketMapper(){

    }

    public static Packet mapToPacket(ByteBuffer buffer) {
        var packetHeader = PacketHeader.from(buffer);
        return switch (packetHeader.packetId()) {
            case MOTION -> PacketMotionData.from(buffer, packetHeader);
            case CAR_TELEMETRY -> PacketCarTelemetryData.from(buffer, packetHeader);
            default -> null;
        };
    }
}
