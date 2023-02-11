package com.jordanupmc.publisher;


import com.jordanupmc.core.packet.PacketCarTelemetryData;
import com.jordanupmc.publisher.dto.CarTelemetryData;
import com.jordanupmc.publisher.dto.PacketCarTelemetryDataDTO;
import com.jordanupmc.publisher.dto.PacketHeader;

final class PacketCarTelemetryDataPublisher extends GenericPacketPublisher<PacketCarTelemetryData, PacketCarTelemetryDataDTO> {

    private static final PacketCarTelemetryDataPublisher INSTANCE = new PacketCarTelemetryDataPublisher();

    public PacketCarTelemetryDataPublisher() {
        super(Topic.PACKET_CAR_TELEMETRY_DATA);
    }

    public static PacketCarTelemetryDataPublisher getInstance() {
        return INSTANCE;
    }

    @Override
    protected PacketCarTelemetryDataDTO toAvroMessage(PacketCarTelemetryData packet) {
        return PacketCarTelemetryDataDTO.newBuilder()
                .setHeader(PacketHeader.newBuilder()
                        .setPacketFormat(packet.header().packetFormat())
                        .setGameMajorVersion(packet.header().gameMajorVersion())
                        .setGameMinorVersion(packet.header().gameMinorVersion())
                        .setPacketVersion(packet.header().packetVersion())
                        .setPacketId(mapPacketId(packet.header().packetId()))
                        .setSessionUID(packet.header().sessionUID())
                        .setSessionTime(packet.header().sessionTime())
                        .setFrameIdentifier(packet.header().frameIdentifier())
                        .setPlayerCarIndex(packet.header().playerCarIndex())
                        .setSecondaryPlayerCarIndex(packet.header().secondaryPlayerCarIndex())
                        .build()
                )
                .setCarTelem(CarTelemetryData.newBuilder()
                        .setSpeed(packet.carTelem().speed())
                        .setThrottle(packet.carTelem().throttle())
                        .setSteer(packet.carTelem().steer())
                        .setBrake(packet.carTelem().brake())
                        .setClutch(packet.carTelem().clutch())
                        .setGear(packet.carTelem().gear())
                        .setEngineRPM(packet.carTelem().engineRPM())
                        .setDrs(packet.carTelem().drs())
                        .setRevLightsPercent(packet.carTelem().revLightsPercent())
                        .setBrakesTemperature(packet.carTelem().brakesTemperature())
                        .setTyresSurfaceTemperature(mapToListInteger(packet.carTelem().tyresSurfaceTemperature()))
                        .setTyresInnerTemperature(mapToListInteger(packet.carTelem().tyresInnerTemperature()))
                        .setEngineTemperature(packet.carTelem().engineTemperature())
                        .setTyresPressure(packet.carTelem().tyresPressure())
                        .setSurfaceType(mapToListInteger(packet.carTelem().surfaceType()))
                        .build()
                )
                .setButtonStatus(packet.buttonStatus())
                .setMfdPanelIndex(packet.mfdPanelIndex())
                .setMfdPanelIndexSecondaryPlayer(packet.mfdPanelIndexSecondaryPlayer())
                .setUggestedGear(packet.uggestedGear())
                .build();
    }

}
