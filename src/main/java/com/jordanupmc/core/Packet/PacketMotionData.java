package com.jordanupmc.core.Packet;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.stream.IntStream;

import static com.jordanupmc.core.ByteBufferHelper.getFloat;

public record PacketMotionData(
        PacketHeader header,
        List<CarMotionData> carMotionData,
        // Extra player car ONLY data
        List<Float> suspensionPosition,
        List<Float> suspensionVelocity,
        List<Float> suspensionAcceleration,
        List<Float> wheelSpeed,
        List<Float> wheelSlip,
        float localVelocityX,
        float localVelocityY,
        float localVelocityZ,
        float angularVelocityX,
        float angularVelocityY,
        float angularVelocityZ,
        float angularAccelerationX,
        float angularAccelerationY,
        float angularAccelerationZ,
        float frontWheelsAngle
) implements Packet {
    private static final int MAX_PLAYERS = 22;

    public static PacketMotionData from(ByteBuffer buffer, PacketHeader packetHeader) {
        return new PacketMotionData(
                packetHeader,
                initCarMotionData(buffer),
                initWheelList(buffer),
                initWheelList(buffer),
                initWheelList(buffer),
                initWheelList(buffer),
                initWheelList(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer)
        );
    }

    private static List<Float> initWheelList(ByteBuffer buffer) {
        return List.of(getFloat(buffer), getFloat(buffer), getFloat(buffer), getFloat(buffer));
    }

    private static List<CarMotionData> initCarMotionData(ByteBuffer buffer) {
        return IntStream.range(0, MAX_PLAYERS)
                .mapToObj(i -> CarMotionData.from(buffer))
                .toList();
    }
}
