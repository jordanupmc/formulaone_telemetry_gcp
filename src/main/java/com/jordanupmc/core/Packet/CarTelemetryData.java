package com.jordanupmc.core.Packet;

import java.nio.ByteBuffer;
import java.util.List;

import static com.jordanupmc.core.ByteBufferHelper.*;
 public record CarTelemetryData(
        int speed,
        float throttle,
        float steer,
        float brake,
        short clutch,
        byte gear,
        int engineRPM,
        short drs,
        short revLightsPercent,
        List<Integer> brakesTemperature,
        List<Short> tyresSurfaceTemperature,
        List<Short> tyresInnerTemperature,
        int engineTemperature,
        List<Float> tyresPressure,
        List<Short> surfaceType
) {
    public static CarTelemetryData from(ByteBuffer buffer) {
        return new CarTelemetryData(
                getUnsignedShort(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getUnsignedByte(buffer),
                getByte(buffer),
                getUnsignedShort(buffer),
                getUnsignedByte(buffer),
                getUnsignedByte(buffer),
                initListInteger(buffer),
                initListShort(buffer),
                initListShort(buffer),
                getUnsignedShort(buffer),
                initListFloat(buffer),
                initListShort(buffer)
        );
    }

    private static List<Short> initListShort(ByteBuffer buffer) {
        return List.of(getUnsignedByte(buffer), getUnsignedByte(buffer),
                getUnsignedByte(buffer), getUnsignedByte(buffer));
    }

    private static List<Integer> initListInteger(ByteBuffer buffer) {
        return List.of(getUnsignedShort(buffer), getUnsignedShort(buffer),
                getUnsignedShort(buffer), getUnsignedShort(buffer));
    }

    private static List<Float> initListFloat(ByteBuffer buffer) {
        return List.of(getFloat(buffer), getFloat(buffer), getFloat(buffer), getFloat(buffer));
    }
}
