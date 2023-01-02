package com.jordanupmc.core.Packet;

import java.util.Arrays;

public enum PacketId {
    MOTION(0),
    SESSION(1),
    LAP_DATA(2),
    EVENT(3),
    PARTICIPANTS(4),
    CAR_SETUPS(5),
    CAR_TELEMETRY(6),
    CAR_STATUS(7),
    FINAL_CLASSIFICATION(8),
    LOBBY_INFO(9),
    CAR_DAMAGE(10),
    SESSION_HISTORY(11);

    private final short id;

    PacketId(int id) {
        this.id = (short) id;
    }

    public short getId() {
        return id;
    }

    static PacketId valueFrom(short id) {
        var value = Arrays.stream(PacketId.values())
                .filter(packetId -> packetId.id == id)
                .findFirst();
        if (value.isEmpty()) {
            throw new IllegalArgumentException("Unknown id " + id);
        }
        return value.get();
    }
}
