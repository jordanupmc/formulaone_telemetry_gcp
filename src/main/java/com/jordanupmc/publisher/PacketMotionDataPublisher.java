package com.jordanupmc.publisher;


import com.jordanupmc.core.packet.CarMotionData;
import com.jordanupmc.core.packet.PacketMotionData;
import com.jordanupmc.publisher.dto.PacketMotionDataDTO;

import java.util.List;

final class PacketMotionDataPublisher extends GenericPacketPublisher<PacketMotionData, PacketMotionDataDTO> {

    private static final PacketMotionDataPublisher INSTANCE = new PacketMotionDataPublisher();

    public PacketMotionDataPublisher() {
        super(Topic.PACKET_MOTION_DATA);
    }

    public static PacketMotionDataPublisher getInstance() {
        return INSTANCE;
    }

    @Override
    protected PacketMotionDataDTO toAvroMessage(PacketMotionData packet) {
        return PacketMotionDataDTO.newBuilder()
                .setHeader(toAvroMessage(packet.header()))
                .setCarMotionData(getCarMotionData(packet.carMotionData()))
                .setSuspensionPosition(packet.suspensionPosition())
                .setSuspensionVelocity(packet.suspensionVelocity())
                .setSuspensionAcceleration(packet.suspensionAcceleration())
                .setWheelSpeed(packet.wheelSpeed())
                .setWheelSlip(packet.wheelSlip())
                .setLocalVelocityX(packet.localVelocityX())
                .setLocalVelocityY(packet.localVelocityY())
                .setLocalVelocityZ(packet.localVelocityZ())
                .setAngularVelocityX(packet.angularVelocityX())
                .setAngularVelocityY(packet.angularVelocityY())
                .setAngularVelocityZ(packet.angularVelocityZ())
                .setAngularAccelerationX(packet.angularAccelerationX())
                .setAngularAccelerationY(packet.angularAccelerationY())
                .setAngularAccelerationZ(packet.angularAccelerationZ())
                .setFrontWheelsAngle(packet.frontWheelsAngle())
                .build();
    }

    private static List<com.jordanupmc.publisher.dto.CarMotionData> getCarMotionData(List<CarMotionData> carMotionData) {
        return carMotionData
                .stream()
                .map(motionData -> com.jordanupmc.publisher.dto.CarMotionData.newBuilder()
                        .setWorldPositionX(motionData.worldPositionX())
                        .setWorldPositionY(motionData.worldPositionY())
                        .setWorldPositionZ(motionData.worldPositionZ())
                        .setWorldVelocityX(motionData.worldVelocityX())
                        .setWorldVelocityY(motionData.worldVelocityY())
                        .setWorldVelocityZ(motionData.worldVelocityZ())
                        .setWorldForwardDirX(motionData.worldForwardDirX())
                        .setWorldForwardDirY(motionData.worldForwardDirY())
                        .setWorldForwardDirZ(motionData.worldForwardDirZ())
                        .setWorldRightDirX(motionData.worldRightDirX())
                        .setWorldRightDirY(motionData.worldRightDirY())
                        .setWorldRightDirZ(motionData.worldRightDirZ())
                        .setGForceLateral(motionData.gForceLateral())
                        .setGForceLongitudinal(motionData.gForceLongitudinal())
                        .setGForceVertical(motionData.gForceVertical())
                        .setYaw(motionData.yaw())
                        .setPitch(motionData.pitch())
                        .setRoll(motionData.roll())
                        .build())
                .toList();
    }
}
