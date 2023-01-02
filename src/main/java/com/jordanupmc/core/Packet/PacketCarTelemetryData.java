package com.jordanupmc.core.Packet;

import com.jordanupmc.core.ByteBufferHelper;

import java.nio.ByteBuffer;

public record PacketCarTelemetryData(
        PacketHeader header,
        CarTelemetryData carTelem,
        long buttonStatus,
        short mfdPanelIndex,
        short mfdPanelIndexSecondaryPlayer,
        short uggestedGear
) implements Packet {
    public static PacketCarTelemetryData from(ByteBuffer buffer, PacketHeader header) {
        return new PacketCarTelemetryData(
                header,
                CarTelemetryData.from(buffer),
                ByteBufferHelper.getUnsignedInt(buffer),
                ByteBufferHelper.getUnsignedByte(buffer),
                ByteBufferHelper.getUnsignedByte(buffer),
                ByteBufferHelper.getByte(buffer)
        );
    }
}
