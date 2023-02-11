package com.jordanupmc.publisher;

import com.jordanupmc.core.packet.CarMotionData;
import com.jordanupmc.core.packet.PacketHeader;
import com.jordanupmc.core.packet.PacketMotionData;
import com.jordanupmc.publisher.dto.PacketMotionDataDTO;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Consumer;

import static com.jordanupmc.core.packet.PacketId.MOTION;
import static org.assertj.core.api.Assertions.assertThat;

public class PacketMotionDataPublisherTest extends GenericPacketPublisherTest<PacketMotionData, PacketMotionDataDTO> {
    public PacketMotionDataPublisherTest() {
        super(PacketMotionDataPublisher.getInstance(), PacketMotionDataDTO.class);
    }

    @Override
    protected PacketMotionData getMessage() {
        return new PacketMotionData(
                new PacketHeader(2020, (short) 1, (short) 18, (short) 1, MOTION, new BigInteger("7368895457965673374"), 251.802f, 4931L, (short) 0, (short) 255),
                List.of(
                        new CarMotionData(-316.35065f, -7.7912936f, 802.6721f, -46.567135f, -1.3065268f, -60.443962f, 45232, 64940, 39826, 25717, 64976, 45239, 1.7130206f, 0.34347844f, 0.10179716f, -2.4732602f, 0.0021317564f, 0.017097816f),
                        new CarMotionData(-563.77435f, -10.195194f, 463.80127f, 0.0f, 0.0f, 0.0f, 19807, 71, 39438, 26097, 113, 19808, 0.0f, 0.0f, 0.0f, 2.492365f, -0.004071695f, -0.003448997f),
                        new CarMotionData(-493.27432f, -9.4598f, 373.04263f, 0.0f, 0.0f, 0.0f, 18883, 294, 38759, 26778, 65361, 18882, 0.0f, 0.0f, 0.0f, 2.527414f, -8.0730073E-4f, 0.0053436267f),
                        new CarMotionData(-492.17853f, -9.571247f, 383.71457f, 0.0f, 0.0f, 0.0f, 18749, 306, 38666, 26872, 65353, 18749, 0.0f, 0.0f, 0.0f, 2.532384f, -7.4449927E-4f, 0.0056088655f),
                        new CarMotionData(-502.80936f, -9.602778f, 386.0852f, 0.0f, 0.0f, 0.0f, 18809, 210, 38707, 26830, 65309, 18808, 0.0f, 0.0f, 0.0f, 2.5301533f, 0.0020137525f, 0.0069566555f),
                        new CarMotionData(-501.68372f, -9.70199f, 396.4705f, 0.0f, 0.0f, 0.0f, 19158, 433, 38957, 26582, 65364, 19157, 0.0f, 0.0f, 0.0f, 2.517106f, -0.0034746854f, 0.0052607446f),
                        new CarMotionData(-563.4474f, -10.208182f, 464.69424f, 0.0f, 0.0f, 0.0f, 20168, 114, 39715, 25821, 65328, 20167, 0.0f, 0.0f, 0.0f, 2.4785082f, 0.0028688377f, 0.0063656163f),
                        new CarMotionData(-511.1791f, -9.859784f, 409.50922f, 0.0f, 0.0f, 0.0f, 19195, 249, 38982, 26555, 65285, 19193, 0.0f, 0.0f, 0.0f, 2.515715f, 0.001745248f, 0.007666429f),
                        new CarMotionData(-521.4671f, -9.877785f, 411.71024f, 0.0f, 0.0f, 0.0f, 19298, 286, 39057, 26480, 65302, 19297, 0.0f, 0.0f, 0.0f, 2.5118132f, 6.323328E-4f, 0.0071594f),
                        new CarMotionData(-520.3814f, -9.966109f, 422.48615f, 0.0f, 0.0f, 0.0f, 19401, 139, 39131, 26405, 65315, 19400, 0.0f, 0.0f, 0.0f, 2.507917f, 0.002932878f, 0.006769465f),
                        new CarMotionData(-530.65137f, -9.981455f, 424.73862f, 0.0f, 0.0f, 0.0f, 18685, 222, 38620, 26916, 65395, 18685, 0.0f, 0.0f, 0.0f, 2.5347712f, -3.354816E-4f, 0.004310052f),
                        new CarMotionData(-529.93176f, -10.055326f, 435.31024f, 0.0f, 0.0f, 0.0f, 19415, 149, 39141, 26395, 65357, 19414, 0.0f, 0.0f, 0.0f, 2.5074048f, 0.0017046339f, 0.005469941f),
                        new CarMotionData(-540.17505f, -10.06264f, 437.6696f, 0.0f, 0.0f, 0.0f, 19434, 144, 39155, 26381, 65407, 19433, 0.0f, 0.0f, 0.0f, 2.506683f, 5.645243E-4f, 0.003951444f),
                        new CarMotionData(-539.0619f, -10.141988f, 448.3726f, 0.0f, 0.0f, 0.0f, 19413, 85, 39140, 26396, 65422, 19413, 0.0f, 0.0f, 0.0f, 2.5074515f, 0.0012744428f, 0.0035076158f),
                        new CarMotionData(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f),
                        new CarMotionData(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f),
                        new CarMotionData(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f),
                        new CarMotionData(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f),
                        new CarMotionData(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f),
                        new CarMotionData(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f),
                        new CarMotionData(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f),
                        new CarMotionData(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f)
                ),
                List.of(-0.5723845f, 11.250688f, 11.773995f, 21.609667f),
                List.of(-24.28396f, -55.36373f, -16.623146f, -39.564304f),
                List.of(-1483.0167f, -1439.1259f, -1396.4849f, -1459.8252f),
                List.of(76.55574f, 76.78748f, 76.22732f, 76.456436f),
                List.of(0.0045086066f, 0.0051219333f, 3.5876583E-4f, 5.7132234E-4f),
                -0.91560626f, 0.09912717f, 76.307434f, 0.036429193f,
                0.12827669f, 0.007331146f, 0.54829395f,
                -2.2429798f, 0.08975932f, -0.0f
        );
    }

    @Override
    protected Consumer<PacketMotionDataDTO> assertMessage() {
        // I know...
        return (message)-> assertThat(message.toString()).isEqualTo("{\"angularAccelerationX\": 0.54829395, \"angularAccelerationY\": -2.2429798, \"angularAccelerationZ\": 0.08975932," +
                " \"angularVelocityX\": 0.036429193, \"angularVelocityY\": 0.12827669, \"angularVelocityZ\": 0.007331146, \"carMotionData\": [{\"gForceLateral\": 1.7130206, \"gForceLongitudinal\": 0.34347844, \"gForceVertical\": 0.10179716, \"pitch\": 0.0021317564, \"roll\": 0.017097816, \"worldForwardDirX\": 45232, \"worldForwardDirY\": 64940, \"worldForwardDirZ\": 39826, \"worldPositionX\": -316.35065, \"worldPositionY\": -7.7912936," +
                " \"worldPositionZ\": 802.6721, \"worldRightDirX\": 25717, \"worldRightDirY\": 64976, \"worldRightDirZ\": 45239, \"worldVelocityX\": -46.567135, \"worldVelocityY\": -1.3065268," +
                " \"worldVelocityZ\": -60.443962, \"yaw\": -2.4732602}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": -0.004071695, \"roll\": -0.003448997, \"worldForwardDirX\": 19807, \"worldForwardDirY\": 71, \"worldForwardDirZ\": 39438, \"worldPositionX\": -563.77435, \"worldPositionY\": -10.195194, \"worldPositionZ\": 463.80127," +
                " \"worldRightDirX\": 26097, \"worldRightDirY\": 113, \"worldRightDirZ\": 19808, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 2.492365}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": -8.0730073E-4, \"roll\": 0.0053436267, \"worldForwardDirX\": 18883, \"worldForwardDirY\": 294, \"worldForwardDirZ\": 38759, \"worldPositionX\": -493.27432, \"worldPositionY\": -9.4598, \"worldPositionZ\": 373.04263," +
                " \"worldRightDirX\": 26778, \"worldRightDirY\": 65361, \"worldRightDirZ\": 18882, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 2.527414}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": -7.4449927E-4, \"roll\": 0.0056088655, \"worldForwardDirX\": 18749, \"worldForwardDirY\": 306, \"worldForwardDirZ\": 38666, \"worldPositionX\": -492.17853, \"worldPositionY\": -9.571247, \"worldPositionZ\": 383.71457," +
                " \"worldRightDirX\": 26872, \"worldRightDirY\": 65353, \"worldRightDirZ\": 18749, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 2.532384}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 0.0020137525, \"roll\": 0.0069566555, " +
                "\"worldForwardDirX\": 18809, \"worldForwardDirY\": 210, \"worldForwardDirZ\": 38707, \"worldPositionX\": -502.80936, \"worldPositionY\": -9.602778, \"worldPositionZ\": 386.0852, \"worldRightDirX\": 26830, \"worldRightDirY\": 65309, \"worldRightDirZ\": 18808, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 2.5301533}," +
                " {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": -0.0034746854, \"roll\": 0.0052607446, \"worldForwardDirX\": 19158, \"worldForwardDirY\": 433, \"worldForwardDirZ\": 38957, \"worldPositionX\": -501.68372, \"worldPositionY\": -9.70199, \"worldPositionZ\": 396.4705, \"worldRightDirX\": 26582, \"worldRightDirY\": 65364," +
                " \"worldRightDirZ\": 19157, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 2.517106}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 0.0028688377, \"roll\": 0.0063656163, \"worldForwardDirX\": 20168, \"worldForwardDirY\": 114, \"worldForwardDirZ\": 39715, \"worldPositionX\": -563.4474, \"worldPositionY\": -10.208182, \"worldPositionZ\": 464.69424, \"worldRightDirX\": 25821, \"worldRightDirY\": 65328, \"worldRightDirZ\": 20167, \"worldVelocityX\": 0.0," +
                " \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 2.4785082}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 0.001745248, \"roll\": 0.007666429, \"worldForwardDirX\": 19195, \"worldForwardDirY\": 249, \"worldForwardDirZ\": 38982, \"worldPositionX\": -511.1791, \"worldPositionY\": -9.859784, \"worldPositionZ\": 409.50922, \"worldRightDirX\": 26555, \"worldRightDirY\": 65285, \"worldRightDirZ\": 19193," +
                " \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 2.515715}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 6.323328E-4, \"roll\": 0.0071594, \"worldForwardDirX\": 19298, \"worldForwardDirY\": 286, \"worldForwardDirZ\": 39057, \"worldPositionX\": -521.4671, \"worldPositionY\": -9.877785, \"worldPositionZ\": 411.71024, \"worldRightDirX\": 26480, \"worldRightDirY\": 65302, \"worldRightDirZ\": 19297, \"worldVelocityX\": 0.0," +
                " \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 2.5118132}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 0.002932878, \"roll\": 0.006769465, \"worldForwardDirX\": 19401, \"worldForwardDirY\": 139, \"worldForwardDirZ\": 39131, \"worldPositionX\": -520.3814, \"worldPositionY\": -9.966109, \"worldPositionZ\": 422.48615, \"worldRightDirX\": 26405, \"worldRightDirY\": 65315, \"worldRightDirZ\": 19400, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 2.507917}," +
                " {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": -3.354816E-4, \"roll\": 0.004310052, \"worldForwardDirX\": 18685, \"worldForwardDirY\": 222, \"worldForwardDirZ\": 38620," +
                " \"worldPositionX\": -530.65137, \"worldPositionY\": -9.981455, \"worldPositionZ\": 424.73862, \"worldRightDirX\": 26916, \"worldRightDirY\": 65395, \"worldRightDirZ\": 18685, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 2.5347712}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 0.0017046339, \"roll\": 0.005469941, \"worldForwardDirX\": 19415, \"worldForwardDirY\": 149, \"worldForwardDirZ\": 39141, \"worldPositionX\": -529.93176, \"worldPositionY\": -10.055326," +
                " \"worldPositionZ\": 435.31024, \"worldRightDirX\": 26395, \"worldRightDirY\": 65357, \"worldRightDirZ\": 19414, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 2.5074048}," +
                " {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 5.645243E-4, \"roll\": 0.003951444, \"worldForwardDirX\": 19434, \"worldForwardDirY\": 144, \"worldForwardDirZ\": 39155, \"worldPositionX\": -540.17505, \"worldPositionY\": -10.06264, \"worldPositionZ\": 437.6696, \"worldRightDirX\": 26381, \"worldRightDirY\": 65407, \"worldRightDirZ\": 19433, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 2.506683}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0," +
                " \"pitch\": 0.0012744428, \"roll\": 0.0035076158, \"worldForwardDirX\": 19413, \"worldForwardDirY\": 85, \"worldForwardDirZ\": 39140, \"worldPositionX\": -539.0619," +
                " \"worldPositionY\": -10.141988, \"worldPositionZ\": 448.3726, \"worldRightDirX\": 26396, \"worldRightDirY\": 65422, \"worldRightDirZ\": 19413, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 2.5074515}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 0.0, \"roll\": 0.0, \"worldForwardDirX\": 0, \"worldForwardDirY\": 0, \"worldForwardDirZ\": 0, \"worldPositionX\": 0.0, \"worldPositionY\": 0.0, \"worldPositionZ\": 0.0, \"worldRightDirX\": 0, \"worldRightDirY\": 0, \"worldRightDirZ\": 0," +
                " \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 0.0}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 0.0, \"roll\": 0.0, \"worldForwardDirX\": 0, \"worldForwardDirY\": 0, \"worldForwardDirZ\": 0, \"worldPositionX\": 0.0, \"worldPositionY\": 0.0, \"worldPositionZ\": 0.0, \"worldRightDirX\": 0, \"worldRightDirY\": 0, \"worldRightDirZ\": 0, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 0.0}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0," +
                " \"pitch\": 0.0, \"roll\": 0.0, \"worldForwardDirX\": 0, \"worldForwardDirY\": 0, \"worldForwardDirZ\": 0, \"worldPositionX\": 0.0, \"worldPositionY\": 0.0, \"worldPositionZ\": 0.0, \"worldRightDirX\": 0, \"worldRightDirY\": 0, \"worldRightDirZ\": 0, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 0.0}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 0.0, \"roll\": 0.0, \"worldForwardDirX\": 0, \"worldForwardDirY\": 0, \"worldForwardDirZ\": 0, \"worldPositionX\": 0.0, \"worldPositionY\": 0.0, \"worldPositionZ\": 0.0," +
                " \"worldRightDirX\": 0, \"worldRightDirY\": 0, \"worldRightDirZ\": 0, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 0.0}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 0.0, \"roll\": 0.0, \"worldForwardDirX\": 0, \"worldForwardDirY\": 0, \"worldForwardDirZ\": 0, \"worldPositionX\": 0.0, \"worldPositionY\": 0.0, \"worldPositionZ\": 0.0, \"worldRightDirX\": 0," +
                " \"worldRightDirY\": 0, \"worldRightDirZ\": 0, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 0.0}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 0.0, \"roll\": 0.0, \"worldForwardDirX\": 0, \"worldForwardDirY\": 0, \"worldForwardDirZ\": 0, \"worldPositionX\": 0.0, \"worldPositionY\": 0.0, \"worldPositionZ\": 0.0, \"worldRightDirX\": 0, \"worldRightDirY\": 0, \"worldRightDirZ\": 0, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 0.0}, {\"gForceLateral\": 0.0," +
                " \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 0.0, \"roll\": 0.0, \"worldForwardDirX\": 0, \"worldForwardDirY\": 0, \"worldForwardDirZ\": 0, \"worldPositionX\": 0.0, \"worldPositionY\": 0.0, \"worldPositionZ\": 0.0, \"worldRightDirX\": 0, \"worldRightDirY\": 0, \"worldRightDirZ\": 0, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 0.0}, {\"gForceLateral\": 0.0, \"gForceLongitudinal\": 0.0, \"gForceVertical\": 0.0, \"pitch\": 0.0, \"roll\": 0.0, \"worldForwardDirX\": 0, \"worldForwardDirY\": 0, \"worldForwardDirZ\": 0, \"worldPositionX\": 0.0," +
                " \"worldPositionY\": 0.0, \"worldPositionZ\": 0.0, \"worldRightDirX\": 0, \"worldRightDirY\": 0, \"worldRightDirZ\": 0, \"worldVelocityX\": 0.0, \"worldVelocityY\": 0.0, \"worldVelocityZ\": 0.0, \"yaw\": 0.0}], \"frontWheelsAngle\": -0.0, \"header\": {\"frameIdentifier\": 4931, \"gameMajorVersion\": 1, \"gameMinorVersion\": 18, \"packetFormat\": 2020, \"packetId\": \"MOTION\", \"packetVersion\": 1, \"playerCarIndex\": 0, \"secondaryPlayerCarIndex\": 255, \"sessionTime\": 251.802, \"sessionUID\": 7368895457965673374}, \"localVelocityX\": -0.91560626, \"localVelocityY\": 0.09912717," +
                " \"localVelocityZ\": 76.307434, \"suspensionAcceleration\": [-1483.0167, -1439.1259, -1396.4849, -1459.8252]," +
                " \"suspensionPosition\": [-0.5723845, 11.250688, 11.773995, 21.609667], \"suspensionVelocity\": [-24.28396, -55.36373, -16.623146, -39.564304], \"wheelSlip\": [0.0045086066, 0.0051219333, 3.5876583E-4, 5.7132234E-4], \"wheelSpeed\": [76.55574, 76.78748, 76.22732, 76.456436]}");
    }
}
