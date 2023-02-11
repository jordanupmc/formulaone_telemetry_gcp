package com.jordanupmc.publisher;

import com.jordanupmc.core.packet.PacketCarTelemetryData;
import com.jordanupmc.core.packet.PacketMotionData;
import com.jordanupmc.publisher.dto.PacketCarTelemetryDataDTO;
import com.jordanupmc.publisher.dto.PacketMotionDataDTO;


public class PacketPublisherFactory {

    private PacketPublisherFactory() {
    }

    public static GenericPacketPublisher<PacketCarTelemetryData, PacketCarTelemetryDataDTO> getPacketPublisher(PacketCarTelemetryData packetCarTelemetryData) {
        return PacketCarTelemetryDataPublisher.getInstance();
    }

    public static GenericPacketPublisher<PacketMotionData, PacketMotionDataDTO> getPacketPublisher(PacketMotionData packetMotionData) {
        return PacketMotionDataPublisher.getInstance();
    }
}
