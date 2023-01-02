package com.jordanupmc.core.Packet;

public sealed interface Packet permits PacketCarTelemetryData, PacketMotionData {
    PacketHeader header();
}
