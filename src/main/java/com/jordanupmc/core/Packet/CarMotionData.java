package com.jordanupmc.core.Packet;

import java.nio.ByteBuffer;

import static com.jordanupmc.core.ByteBufferHelper.getFloat;
import static com.jordanupmc.core.ByteBufferHelper.getUnsignedShort;
 public record CarMotionData(
        float worldPositionX,
        float worldPositionY,
        float worldPositionZ,
        float worldVelocityX,
        float worldVelocityY,
        float worldVelocityZ,
        int worldForwardDirX,
        int worldForwardDirY,
        int worldForwardDirZ,
        int worldRightDirX,
        int worldRightDirY,
        int worldRightDirZ,
        float gForceLateral,
        float gForceLongitudinal,
        float gForceVertical,
        float yaw,
        float pitch,
        float roll) {

    static CarMotionData from(ByteBuffer buffer) {
        return new CarMotionData(
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getUnsignedShort(buffer),
                getUnsignedShort(buffer),
                getUnsignedShort(buffer),
                getUnsignedShort(buffer),
                getUnsignedShort(buffer),
                getUnsignedShort(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer),
                getFloat(buffer)
        );
    }
}
