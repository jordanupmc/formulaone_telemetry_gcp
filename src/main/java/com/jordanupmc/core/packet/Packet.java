package com.jordanupmc.core.packet;

public sealed interface Packet permits PacketCarTelemetryData, PacketMotionData {
    PacketHeader header();
}
