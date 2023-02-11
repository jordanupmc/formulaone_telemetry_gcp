package com.jordanupmc.publisher;

import com.jordanupmc.core.packet.CarTelemetryData;
import com.jordanupmc.core.packet.PacketCarTelemetryData;
import com.jordanupmc.core.packet.PacketHeader;
import com.jordanupmc.publisher.dto.PacketCarTelemetryDataDTO;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Consumer;

import static com.jordanupmc.core.packet.PacketId.CAR_TELEMETRY;
import static org.assertj.core.api.Assertions.assertThat;

final class PacketCarTelemetryDataPublisherTest extends GenericPacketPublisherTest<PacketCarTelemetryData, PacketCarTelemetryDataDTO> {

    public PacketCarTelemetryDataPublisherTest() {
        super(PacketCarTelemetryDataPublisher.getInstance(), PacketCarTelemetryDataDTO.class);
    }

    @Override
    protected PacketCarTelemetryData getMessage() {
        return new PacketCarTelemetryData(
                new PacketHeader(2020, (short) 1, (short) 18, (short) 1,
                        CAR_TELEMETRY, new BigInteger("7368895457965673374"),
                        251.802f, 4931L, (short) 0, (short) 255),
                new CarTelemetryData(274, 1.0f, 0.0f, 0.0f, (short) 0, (byte) 7,
                        11030, (short) 0, (short) 5,
                        List.of(30, 30, 30, 30),
                        List.of((short) 100, (short) 100, (short) 100, (short) 100),
                        List.of((short) 100, (short) 100, (short) 100, (short) 100),
                        90,
                        List.of(23.573814f, 23.573814f, 22.655354f, 22.655354f),
                        List.of((short) 0, (short) 0, (short) 0, (short) 0)
                ),
                0L, (short) 0, (short) 0, (short) 0
        );
    }

    @Override
    protected Consumer<PacketCarTelemetryDataDTO> assertMessage() {
        return (message) -> {
            assertThat(message.getHeader().getPacketFormat()).isEqualTo(2020);
            assertThat(message.getHeader().getGameMajorVersion()).isEqualTo((short) 1);
            assertThat(message.getHeader().getGameMinorVersion()).isEqualTo((short) 18);
            assertThat(message.getHeader().getPacketVersion()).isEqualTo((short) 1);
            assertThat(message.getHeader().getPacketId()).isEqualTo(com.jordanupmc.publisher.dto.PacketId.CAR_TELEMETRY);
            assertThat(message.getHeader().getSessionUID()).isEqualTo(new BigInteger("7368895457965673374"));
            assertThat(message.getHeader().getSessionTime()).isEqualTo(251.802f);
            assertThat(message.getHeader().getFrameIdentifier()).isEqualTo(4931L);
            assertThat(message.getHeader().getPlayerCarIndex()).isEqualTo((short) 0);
            assertThat(message.getHeader().getSecondaryPlayerCarIndex()).isEqualTo((short) 255);

            assertThat(message).extracting(PacketCarTelemetryDataDTO::getButtonStatus).isEqualTo(0L);
            assertThat(message).extracting(PacketCarTelemetryDataDTO::getMfdPanelIndex).isEqualTo(0);
            assertThat(message).extracting(PacketCarTelemetryDataDTO::getMfdPanelIndexSecondaryPlayer).isEqualTo(0);
            assertThat(message).extracting(PacketCarTelemetryDataDTO::getUggestedGear).isEqualTo(0);

            assertThat(message.getCarTelem().getSpeed()).isEqualTo(274);
            assertThat(message.getCarTelem().getThrottle()).isEqualTo(1.0f);
            assertThat(message.getCarTelem().getSteer()).isEqualTo(0.0f);
            assertThat(message.getCarTelem().getBrake()).isEqualTo(0.0f);
            assertThat(message.getCarTelem().getClutch()).isEqualTo((short) 0);
            assertThat(message.getCarTelem().getGear()).isEqualTo((byte) 7);
            assertThat(message.getCarTelem().getEngineRPM()).isEqualTo(11030);
            assertThat(message.getCarTelem().getDrs()).isEqualTo((short) 0);
            assertThat(message.getCarTelem().getRevLightsPercent()).isEqualTo((short) 5);
            assertThat(message.getCarTelem().getBrakesTemperature()).containsExactly(30, 30, 30, 30);
            assertThat(message.getCarTelem().getTyresSurfaceTemperature()).containsExactly(100, 100, 100, 100);
            assertThat(message.getCarTelem().getTyresInnerTemperature()).containsExactly(100, 100, 100, 100);
            assertThat(message.getCarTelem().getEngineTemperature()).isEqualTo(90);
            assertThat(message.getCarTelem().getTyresPressure()).containsExactly(23.573814f, 23.573814f, 22.655354f, 22.655354f);
            assertThat(message.getCarTelem().getSurfaceType()).containsExactly(0, 0, 0, 0);
        };
    }
}