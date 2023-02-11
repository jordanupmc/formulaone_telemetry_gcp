package com.jordanupmc.publisher;

enum Topic {
    PACKET_MOTION_DATA("packet-motion-data-topic"),
    PACKET_CAR_TELEMETRY_DATA("packet-car-telemetry-data-topic");


    private final String topicId;

    Topic(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicId() {
        return topicId;
    }
}
