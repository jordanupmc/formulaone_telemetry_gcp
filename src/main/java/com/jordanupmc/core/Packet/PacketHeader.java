package com.jordanupmc.core.Packet;

import java.math.BigInteger;
import java.nio.ByteBuffer;

import static com.jordanupmc.core.ByteBufferHelper.*;


/**
 * struct PacketHeader
 * {
 * uint16    m_packetFormat;             // 2020
 * uint8     m_gameMajorVersion;         // Game major version - "X.00"
 * uint8     m_gameMinorVersion;         // Game minor version - "1.XX"
 * uint8     m_packetVersion;            // Version of this packet type, all start from 1
 * uint8     m_packetId;                 // Identifier for the packet type, see below
 * uint64    m_sessionUID;               // Unique identifier for the session
 * float     m_sessionTime;              // Session timestamp
 * uint32    m_frameIdentifier;          // Identifier for the frame the data was retrieved on
 * uint8     m_playerCarIndex;           // Index of player's car in the array
 * uint8     m_secondaryPlayerCarIndex;  // Index of secondary player's car in the array (splitscreen)
 * // 255 if no second player
 * };
 * };
 */
public record PacketHeader(
        int packetFormat,
        short gameMajorVersion,
        short gameMinorVersion,
        short packetVersion,
        PacketId packetId,
        BigInteger sessionUID,
        float sessionTime,
        long frameIdentifier,
        short playerCarIndex,
        short secondaryPlayerCarIndex
) {
    public static PacketHeader from(ByteBuffer buffer) {
        return new PacketHeader(
                getUnsignedShort(buffer),
                getUnsignedByte(buffer),
                getUnsignedByte(buffer),
                getUnsignedByte(buffer),
                PacketId.valueFrom(getUnsignedByte(buffer)),
                getUnsignedLong(buffer),
                getFloat(buffer),
                getUnsignedInt(buffer),
                getUnsignedByte(buffer),
                getUnsignedByte(buffer)
        );
    }
}