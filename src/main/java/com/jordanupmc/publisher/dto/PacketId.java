/**
 * Autogenerated by Avro
 * <p>
 * DO NOT EDIT DIRECTLY
 */
package com.jordanupmc.publisher.dto;

@org.apache.avro.specific.AvroGenerated
public enum PacketId implements org.apache.avro.generic.GenericEnumSymbol<PacketId> {
    MOTION, SESSION, LAP_DATA, EVENT, PARTICIPANTS, CAR_SETUPS, CAR_TELEMETRY, CAR_STATUS, FINAL_CLASSIFICATION, LOBBY_INFO, CAR_DAMAGE, SESSION_HISTORY;
    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"PacketId\",\"namespace\":\"com.jordanupmc.publisher.dto\",\"symbols\":[\"MOTION\",\"SESSION\",\"LAP_DATA\",\"EVENT\",\"PARTICIPANTS\",\"CAR_SETUPS\",\"CAR_TELEMETRY\",\"CAR_STATUS\",\"FINAL_CLASSIFICATION\",\"LOBBY_INFO\",\"CAR_DAMAGE\",\"SESSION_HISTORY\"]}");

    public static org.apache.avro.Schema getClassSchema() {
        return SCHEMA$;
    }

    @Override
    public org.apache.avro.Schema getSchema() {
        return SCHEMA$;
    }
}