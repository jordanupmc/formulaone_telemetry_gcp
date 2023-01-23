package com.jordanupmc.core;

import com.jordanupmc.core.packet.*;
import com.jordanupmc.udpserver.UdpSessionPlayer;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.nio.ByteBuffer;

import static com.jordanupmc.core.packet.PacketId.LAP_DATA;
import static com.jordanupmc.udpserver.Server.BUFFER_BYTES_CAPACITY;
import static com.jordanupmc.udpserver.Server.initBuffer;
import static org.assertj.core.api.Assertions.assertThat;

public class PacketFormatTest {

    private static final String FILE_NAME = "udp_record/udp_record_qualif_silverstone";

    @Test
    void should_format_PacketHeader_correctly_from_buffer() {
        // given
        var buffer = initBufferWithPacket();
        // when
        var packetHeader = PacketHeader.from(buffer);
        // then
        assertThat(packetHeader.packetFormat()).isEqualTo(2020);
        assertThat(packetHeader.gameMajorVersion()).isEqualTo((short) 1);
        assertThat(packetHeader.gameMinorVersion()).isEqualTo((short) 18);
        assertThat(packetHeader.packetVersion()).isEqualTo((short) 1);
        assertThat(packetHeader.packetId()).isEqualTo(LAP_DATA);
        assertThat(packetHeader.sessionUID()).isEqualTo(new BigInteger("7368895457965673374"));
        assertThat(packetHeader.sessionTime()).isEqualTo((float) 251.802);
        assertThat(packetHeader.frameIdentifier()).isEqualTo(4931L);
        assertThat(packetHeader.playerCarIndex()).isEqualTo((short) 0);
        assertThat(packetHeader.secondaryPlayerCarIndex()).isEqualTo((short) 255);
    }

    @Test
    void should_format_PacketCarTelemetryData_correctly_from_buffer() {
        // given
        var buffer = getFirstPacket(PacketId.CAR_TELEMETRY);
        // when
        var packetCarTelemetryData = PacketCarTelemetryData.from(buffer, PacketHeader.from(buffer));
        // then

        assertThat(packetCarTelemetryData)
                .extracting(PacketCarTelemetryData::header)
                .extracting(PacketHeader::packetId)
                .isEqualTo(PacketId.CAR_TELEMETRY);
        assertThat(packetCarTelemetryData).extracting(PacketCarTelemetryData::buttonStatus).isEqualTo(0L);
        assertThat(packetCarTelemetryData).extracting(PacketCarTelemetryData::mfdPanelIndex).isEqualTo((short) 0);
        assertThat(packetCarTelemetryData).extracting(PacketCarTelemetryData::mfdPanelIndexSecondaryPlayer).isEqualTo((short) 0);
        assertThat(packetCarTelemetryData).extracting(PacketCarTelemetryData::uggestedGear).isEqualTo((short) 0);
        assertCarTelemetryData(packetCarTelemetryData.carTelem());
    }

    @Test
    void should_format_PacketMotionData_correctly_from_buffer() {
        // given
        var buffer = getFirstPacket(PacketId.MOTION);
        // when
        var packetMotionData = PacketMotionData.from(buffer, PacketHeader.from(buffer));
        // then

        assertThat(packetMotionData)
                .extracting(PacketMotionData::header)
                .extracting(PacketHeader::packetId)
                .isEqualTo(PacketId.MOTION);
        assertThat(packetMotionData.suspensionPosition()).containsExactly(-0.5723845f, 11.250688f, 11.773995f, 21.609667f);
        assertThat(packetMotionData.suspensionVelocity()).containsExactly(-24.28396f, -55.36373f, -16.623146f, -39.564304f);
        assertThat(packetMotionData.suspensionAcceleration()).containsExactly(-1483.0167f, -1439.1259f, -1396.4849f, -1459.8252f);
        assertThat(packetMotionData.wheelSpeed()).containsExactly(76.55574f, 76.78748f, 76.22732f, 76.456436f);
        assertThat(packetMotionData.wheelSlip()).containsExactly(0.0045086066f, 0.0051219333f, 3.5876583E-4f, 5.7132234E-4f);
        assertThat(packetMotionData.localVelocityX()).isEqualTo(-0.91560626f);
        assertThat(packetMotionData.localVelocityY()).isEqualTo(0.09912717f);
        assertThat(packetMotionData.localVelocityZ()).isEqualTo(76.307434f);
        assertThat(packetMotionData.angularVelocityX()).isEqualTo(0.036429193f);
        assertThat(packetMotionData.angularVelocityY()).isEqualTo(0.12827669f);
        assertThat(packetMotionData.angularVelocityZ()).isEqualTo(0.007331146f);
        assertThat(packetMotionData.angularAccelerationX()).isEqualTo(0.54829395f);
        assertThat(packetMotionData.angularAccelerationY()).isEqualTo(-2.2429798f);
        assertThat(packetMotionData.angularAccelerationZ()).isEqualTo(0.08975932f);
        assertThat(packetMotionData.frontWheelsAngle()).isEqualTo(-0.0f);
        asserCarMotionData(packetMotionData);
    }

    private static void asserCarMotionData(PacketMotionData packetMotionData) {
        assertThat(packetMotionData.carMotionData()).hasSize(22);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::gForceLateral).containsExactly(1.7130206f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                        0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::worldPositionX).containsExactly(-316.35065f, -563.77435f, -493.27432f, -492.17853f, -502.80936f, -501.68372f, -563.4474f,
                        -511.1791f, -521.4671f, -520.3814f, -530.65137f, -529.93176f, -540.17505f, -539.0619f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::worldPositionY).containsExactly(-7.7912936f, -10.195194f, -9.4598f, -9.571247f, -9.602778f, -9.70199f, -10.208182f, -9.859784f, -9.877785f, -9.966109f, -9.981455f, -10.055326f, -10.06264f, -10.141988f, 0.0f,
                        0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::worldPositionZ).containsExactly(802.6721f, 463.80127f, 373.04263f, 383.71457f, 386.0852f, 396.4705f, 464.69424f, 409.50922f, 411.71024f, 422.48615f, 424.73862f,
                        435.31024f, 437.6696f, 448.3726f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::worldVelocityX).containsExactly(-46.567135f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                        0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::worldVelocityY).containsExactly(-1.3065268f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                        0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::worldVelocityZ).containsExactly(-60.443962f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                        0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::worldForwardDirX).containsExactly(45232, 19807, 18883, 18749, 18809, 19158, 20168, 19195, 19298, 19401,
                        18685, 19415, 19434, 19413, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::worldForwardDirY).containsExactly(64940, 71, 294, 306, 210, 433, 114, 249, 286, 139,
                        222, 149, 144, 85, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::worldForwardDirZ).containsExactly(39826, 39438, 38759, 38666, 38707, 38957, 39715, 38982, 39057,
                        39131, 38620, 39141, 39155, 39140, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::worldRightDirX).containsExactly(25717, 26097, 26778, 26872, 26830, 26582, 25821, 26555, 26480,
                        26405, 26916, 26395, 26381, 26396, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::worldRightDirY).containsExactly(64976, 113, 65361, 65353, 65309, 65364, 65328, 65285, 65302, 65315,
                        65395, 65357, 65407, 65422, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::worldRightDirZ).containsExactly(45239, 19808, 18882, 18749, 18808, 19157, 20167,
                        19193, 19297, 19400, 18685, 19414, 19433, 19413, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::gForceLateral).containsExactly(1.7130206f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                        0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::gForceLongitudinal).containsExactly(0.34347844f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                        0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::gForceVertical).containsExactly(0.10179716f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                        0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::yaw).containsExactly(-2.4732602f, 2.492365f, 2.527414f, 2.532384f, 2.5301533f, 2.517106f, 2.4785082f, 2.515715f, 2.5118132f, 2.507917f, 2.5347712f, 2.5074048f,
                        2.506683f, 2.5074515f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::pitch).containsExactly(0.0021317564f, -0.004071695f, -8.0730073E-4f, -7.4449927E-4f, 0.0020137525f, -0.0034746854f, 0.0028688377f, 0.001745248f, 6.323328E-4f, 0.002932878f,
                        -3.354816E-4f, 0.0017046339f, 5.645243E-4f, 0.0012744428f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        assertThat(packetMotionData.carMotionData())
                .extracting(CarMotionData::roll).containsExactly(0.017097816f, -0.003448997f, 0.0053436267f, 0.0056088655f, 0.0069566555f, 0.0052607446f, 0.0063656163f, 0.007666429f, 0.0071594f, 0.006769465f, 0.004310052f,
                        0.005469941f, 0.003951444f, 0.0035076158f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    private static void assertCarTelemetryData(CarTelemetryData carTelemetryData) {
        assertThat(carTelemetryData.speed()).isEqualTo(274);
        assertThat(carTelemetryData.throttle()).isEqualTo((float) 1.0);
        assertThat(carTelemetryData.steer()).isEqualTo((float) 0.0);
        assertThat(carTelemetryData.brake()).isEqualTo((float) 0.0);
        assertThat(carTelemetryData.clutch()).isEqualTo((short) 0);
        assertThat(carTelemetryData.gear()).isEqualTo((byte) 7);
        assertThat(carTelemetryData.engineRPM()).isEqualTo(11030);
        assertThat(carTelemetryData.drs()).isEqualTo((short) 0);
        assertThat(carTelemetryData.revLightsPercent()).isEqualTo((short) 5);
        assertThat(carTelemetryData.brakesTemperature()).containsExactly(30, 30, 30, 30);
        assertThat(carTelemetryData.tyresSurfaceTemperature()).containsExactly((short) 100, (short) 100, (short) 100, (short) 100);
        assertThat(carTelemetryData.tyresInnerTemperature()).containsExactly((short) 100, (short) 100, (short) 100, (short) 100);
        assertThat(carTelemetryData.engineTemperature()).isEqualTo(90);
        assertThat(carTelemetryData.tyresPressure()).containsExactly((float) 23.573814, (float) 23.573814, (float) 22.655354, (float) 22.655354);
        assertThat(carTelemetryData.surfaceType()).containsExactly((short) 0, (short) 0, (short) 0, (short) 0);
    }

    private ByteBuffer initBufferWithPacket() {
        URL resource = UdpSessionPlayer.class.getClassLoader().getResource(FILE_NAME);
        ByteBuffer buffer = initBuffer(BUFFER_BYTES_CAPACITY);
        try (var fos = new FileInputStream(resource.getFile())) {
            while (fos.read(buffer.array()) > 0) {
                return buffer.position(0);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        throw new IllegalStateException("fail to init buffer");
    }

    private ByteBuffer getFirstPacket(PacketId packetId) {
        URL resource = UdpSessionPlayer.class.getClassLoader().getResource(FILE_NAME);
        ByteBuffer buffer = initBuffer(BUFFER_BYTES_CAPACITY);
        try (var fos = new FileInputStream(resource.getFile())) {
            while (fos.read(buffer.array()) > 0) {
                buffer.position(0);
                if (packetId == PacketHeader.from(buffer).packetId()) {
                    return buffer.position(0);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return buffer.position(0);
    }

}
