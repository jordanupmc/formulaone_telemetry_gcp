/**
 * Autogenerated by Avro
 * <p>
 * DO NOT EDIT DIRECTLY
 */
package com.jordanupmc.publisher.dto;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class PacketHeader extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
    private static final long serialVersionUID = 5453286799782738813L;


    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PacketHeader\",\"namespace\":\"com.jordanupmc.publisher.dto\",\"fields\":[{\"name\":\"frameIdentifier\",\"type\":\"long\"},{\"name\":\"gameMajorVersion\",\"type\":{\"type\":\"int\",\"java-class\":\"java.lang.Short\"}},{\"name\":\"gameMinorVersion\",\"type\":{\"type\":\"int\",\"java-class\":\"java.lang.Short\"}},{\"name\":\"packetFormat\",\"type\":\"int\"},{\"name\":\"packetId\",\"type\":{\"type\":\"enum\",\"name\":\"PacketId\",\"symbols\":[\"MOTION\",\"SESSION\",\"LAP_DATA\",\"EVENT\",\"PARTICIPANTS\",\"CAR_SETUPS\",\"CAR_TELEMETRY\",\"CAR_STATUS\",\"FINAL_CLASSIFICATION\",\"LOBBY_INFO\",\"CAR_DAMAGE\",\"SESSION_HISTORY\"]}},{\"name\":\"packetVersion\",\"type\":{\"type\":\"int\",\"java-class\":\"java.lang.Short\"}},{\"name\":\"playerCarIndex\",\"type\":{\"type\":\"int\",\"java-class\":\"java.lang.Short\"}},{\"name\":\"secondaryPlayerCarIndex\",\"type\":{\"type\":\"int\",\"java-class\":\"java.lang.Short\"}},{\"name\":\"sessionTime\",\"type\":\"float\"},{\"name\":\"sessionUID\",\"type\":{\"type\":\"string\",\"java-class\":\"java.math.BigInteger\"}}]}");

    public static org.apache.avro.Schema getClassSchema() {
        return SCHEMA$;
    }

    private static final SpecificData MODEL$ = new SpecificData();

    private static final BinaryMessageEncoder<PacketHeader> ENCODER =
            new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

    private static final BinaryMessageDecoder<PacketHeader> DECODER =
            new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

    /**
     * Return the BinaryMessageEncoder instance used by this class.
     * @return the message encoder used by this class
     */
    public static BinaryMessageEncoder<PacketHeader> getEncoder() {
        return ENCODER;
    }

    /**
     * Return the BinaryMessageDecoder instance used by this class.
     * @return the message decoder used by this class
     */
    public static BinaryMessageDecoder<PacketHeader> getDecoder() {
        return DECODER;
    }

    /**
     * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
     * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
     * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
     */
    public static BinaryMessageDecoder<PacketHeader> createDecoder(SchemaStore resolver) {
        return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
    }

    /**
     * Serializes this PacketHeader to a ByteBuffer.
     * @return a buffer holding the serialized data for this instance
     * @throws java.io.IOException if this instance could not be serialized
     */
    public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
        return ENCODER.encode(this);
    }

    /**
     * Deserializes a PacketHeader from a ByteBuffer.
     * @param b a byte buffer holding serialized data for an instance of this class
     * @return a PacketHeader instance decoded from the given buffer
     * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
     */
    public static PacketHeader fromByteBuffer(
            java.nio.ByteBuffer b) throws java.io.IOException {
        return DECODER.decode(b);
    }

    private long frameIdentifier;
    private int gameMajorVersion;
    private int gameMinorVersion;
    private int packetFormat;
    private com.jordanupmc.publisher.dto.PacketId packetId;
    private int packetVersion;
    private int playerCarIndex;
    private int secondaryPlayerCarIndex;
    private float sessionTime;
    private java.math.BigInteger sessionUID;

    /**
     * Default constructor.  Note that this does not initialize fields
     * to their default values from the schema.  If that is desired then
     * one should use <code>newBuilder()</code>.
     */
    public PacketHeader() {
    }

    /**
     * All-args constructor.
     * @param frameIdentifier The new value for frameIdentifier
     * @param gameMajorVersion The new value for gameMajorVersion
     * @param gameMinorVersion The new value for gameMinorVersion
     * @param packetFormat The new value for packetFormat
     * @param packetId The new value for packetId
     * @param packetVersion The new value for packetVersion
     * @param playerCarIndex The new value for playerCarIndex
     * @param secondaryPlayerCarIndex The new value for secondaryPlayerCarIndex
     * @param sessionTime The new value for sessionTime
     * @param sessionUID The new value for sessionUID
     */
    public PacketHeader(java.lang.Long frameIdentifier, java.lang.Integer gameMajorVersion, java.lang.Integer gameMinorVersion, java.lang.Integer packetFormat, com.jordanupmc.publisher.dto.PacketId packetId, java.lang.Integer packetVersion, java.lang.Integer playerCarIndex, java.lang.Integer secondaryPlayerCarIndex, java.lang.Float sessionTime, java.math.BigInteger sessionUID) {
        this.frameIdentifier = frameIdentifier;
        this.gameMajorVersion = gameMajorVersion;
        this.gameMinorVersion = gameMinorVersion;
        this.packetFormat = packetFormat;
        this.packetId = packetId;
        this.packetVersion = packetVersion;
        this.playerCarIndex = playerCarIndex;
        this.secondaryPlayerCarIndex = secondaryPlayerCarIndex;
        this.sessionTime = sessionTime;
        this.sessionUID = sessionUID;
    }

    @Override
    public org.apache.avro.specific.SpecificData getSpecificData() {
        return MODEL$;
    }

    @Override
    public org.apache.avro.Schema getSchema() {
        return SCHEMA$;
    }

    // Used by DatumWriter.  Applications should not call.
    @Override
    public java.lang.Object get(int field$) {
        switch (field$) {
            case 0:
                return frameIdentifier;
            case 1:
                return gameMajorVersion;
            case 2:
                return gameMinorVersion;
            case 3:
                return packetFormat;
            case 4:
                return packetId;
            case 5:
                return packetVersion;
            case 6:
                return playerCarIndex;
            case 7:
                return secondaryPlayerCarIndex;
            case 8:
                return sessionTime;
            case 9:
                return sessionUID;
            default:
                throw new IndexOutOfBoundsException("Invalid index: " + field$);
        }
    }

    // Used by DatumReader.  Applications should not call.
    @Override
    @SuppressWarnings(value = "unchecked")
    public void put(int field$, java.lang.Object value$) {
        switch (field$) {
            case 0:
                frameIdentifier = (java.lang.Long) value$;
                break;
            case 1:
                gameMajorVersion = (java.lang.Integer) value$;
                break;
            case 2:
                gameMinorVersion = (java.lang.Integer) value$;
                break;
            case 3:
                packetFormat = (java.lang.Integer) value$;
                break;
            case 4:
                packetId = (com.jordanupmc.publisher.dto.PacketId) value$;
                break;
            case 5:
                packetVersion = (java.lang.Integer) value$;
                break;
            case 6:
                playerCarIndex = (java.lang.Integer) value$;
                break;
            case 7:
                secondaryPlayerCarIndex = (java.lang.Integer) value$;
                break;
            case 8:
                sessionTime = (java.lang.Float) value$;
                break;
            case 9:
                sessionUID = (java.math.BigInteger) value$;
                break;
            default:
                throw new IndexOutOfBoundsException("Invalid index: " + field$);
        }
    }

    /**
     * Gets the value of the 'frameIdentifier' field.
     * @return The value of the 'frameIdentifier' field.
     */
    public long getFrameIdentifier() {
        return frameIdentifier;
    }


    /**
     * Sets the value of the 'frameIdentifier' field.
     * @param value the value to set.
     */
    public void setFrameIdentifier(long value) {
        this.frameIdentifier = value;
    }

    /**
     * Gets the value of the 'gameMajorVersion' field.
     * @return The value of the 'gameMajorVersion' field.
     */
    public int getGameMajorVersion() {
        return gameMajorVersion;
    }


    /**
     * Sets the value of the 'gameMajorVersion' field.
     * @param value the value to set.
     */
    public void setGameMajorVersion(int value) {
        this.gameMajorVersion = value;
    }

    /**
     * Gets the value of the 'gameMinorVersion' field.
     * @return The value of the 'gameMinorVersion' field.
     */
    public int getGameMinorVersion() {
        return gameMinorVersion;
    }


    /**
     * Sets the value of the 'gameMinorVersion' field.
     * @param value the value to set.
     */
    public void setGameMinorVersion(int value) {
        this.gameMinorVersion = value;
    }

    /**
     * Gets the value of the 'packetFormat' field.
     * @return The value of the 'packetFormat' field.
     */
    public int getPacketFormat() {
        return packetFormat;
    }


    /**
     * Sets the value of the 'packetFormat' field.
     * @param value the value to set.
     */
    public void setPacketFormat(int value) {
        this.packetFormat = value;
    }

    /**
     * Gets the value of the 'packetId' field.
     * @return The value of the 'packetId' field.
     */
    public com.jordanupmc.publisher.dto.PacketId getPacketId() {
        return packetId;
    }


    /**
     * Sets the value of the 'packetId' field.
     * @param value the value to set.
     */
    public void setPacketId(com.jordanupmc.publisher.dto.PacketId value) {
        this.packetId = value;
    }

    /**
     * Gets the value of the 'packetVersion' field.
     * @return The value of the 'packetVersion' field.
     */
    public int getPacketVersion() {
        return packetVersion;
    }


    /**
     * Sets the value of the 'packetVersion' field.
     * @param value the value to set.
     */
    public void setPacketVersion(int value) {
        this.packetVersion = value;
    }

    /**
     * Gets the value of the 'playerCarIndex' field.
     * @return The value of the 'playerCarIndex' field.
     */
    public int getPlayerCarIndex() {
        return playerCarIndex;
    }


    /**
     * Sets the value of the 'playerCarIndex' field.
     * @param value the value to set.
     */
    public void setPlayerCarIndex(int value) {
        this.playerCarIndex = value;
    }

    /**
     * Gets the value of the 'secondaryPlayerCarIndex' field.
     * @return The value of the 'secondaryPlayerCarIndex' field.
     */
    public int getSecondaryPlayerCarIndex() {
        return secondaryPlayerCarIndex;
    }


    /**
     * Sets the value of the 'secondaryPlayerCarIndex' field.
     * @param value the value to set.
     */
    public void setSecondaryPlayerCarIndex(int value) {
        this.secondaryPlayerCarIndex = value;
    }

    /**
     * Gets the value of the 'sessionTime' field.
     * @return The value of the 'sessionTime' field.
     */
    public float getSessionTime() {
        return sessionTime;
    }


    /**
     * Sets the value of the 'sessionTime' field.
     * @param value the value to set.
     */
    public void setSessionTime(float value) {
        this.sessionTime = value;
    }

    /**
     * Gets the value of the 'sessionUID' field.
     * @return The value of the 'sessionUID' field.
     */
    public java.math.BigInteger getSessionUID() {
        return sessionUID;
    }


    /**
     * Sets the value of the 'sessionUID' field.
     * @param value the value to set.
     */
    public void setSessionUID(java.math.BigInteger value) {
        this.sessionUID = value;
    }

    /**
     * Creates a new PacketHeader RecordBuilder.
     * @return A new PacketHeader RecordBuilder
     */
    public static com.jordanupmc.publisher.dto.PacketHeader.Builder newBuilder() {
        return new com.jordanupmc.publisher.dto.PacketHeader.Builder();
    }

    /**
     * Creates a new PacketHeader RecordBuilder by copying an existing Builder.
     * @param other The existing builder to copy.
     * @return A new PacketHeader RecordBuilder
     */
    public static com.jordanupmc.publisher.dto.PacketHeader.Builder newBuilder(com.jordanupmc.publisher.dto.PacketHeader.Builder other) {
        if (other == null) {
            return new com.jordanupmc.publisher.dto.PacketHeader.Builder();
        } else {
            return new com.jordanupmc.publisher.dto.PacketHeader.Builder(other);
        }
    }

    /**
     * Creates a new PacketHeader RecordBuilder by copying an existing PacketHeader instance.
     * @param other The existing instance to copy.
     * @return A new PacketHeader RecordBuilder
     */
    public static com.jordanupmc.publisher.dto.PacketHeader.Builder newBuilder(com.jordanupmc.publisher.dto.PacketHeader other) {
        if (other == null) {
            return new com.jordanupmc.publisher.dto.PacketHeader.Builder();
        } else {
            return new com.jordanupmc.publisher.dto.PacketHeader.Builder(other);
        }
    }

    /**
     * RecordBuilder for PacketHeader instances.
     */
    @org.apache.avro.specific.AvroGenerated
    public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PacketHeader>
            implements org.apache.avro.data.RecordBuilder<PacketHeader> {

        private long frameIdentifier;
        private int gameMajorVersion;
        private int gameMinorVersion;
        private int packetFormat;
        private com.jordanupmc.publisher.dto.PacketId packetId;
        private int packetVersion;
        private int playerCarIndex;
        private int secondaryPlayerCarIndex;
        private float sessionTime;
        private java.math.BigInteger sessionUID;

        /** Creates a new Builder */
        private Builder() {
            super(SCHEMA$, MODEL$);
        }

        /**
         * Creates a Builder by copying an existing Builder.
         * @param other The existing Builder to copy.
         */
        private Builder(com.jordanupmc.publisher.dto.PacketHeader.Builder other) {
            super(other);
            if (isValidValue(fields()[0], other.frameIdentifier)) {
                this.frameIdentifier = data().deepCopy(fields()[0].schema(), other.frameIdentifier);
                fieldSetFlags()[0] = other.fieldSetFlags()[0];
            }
            if (isValidValue(fields()[1], other.gameMajorVersion)) {
                this.gameMajorVersion = data().deepCopy(fields()[1].schema(), other.gameMajorVersion);
                fieldSetFlags()[1] = other.fieldSetFlags()[1];
            }
            if (isValidValue(fields()[2], other.gameMinorVersion)) {
                this.gameMinorVersion = data().deepCopy(fields()[2].schema(), other.gameMinorVersion);
                fieldSetFlags()[2] = other.fieldSetFlags()[2];
            }
            if (isValidValue(fields()[3], other.packetFormat)) {
                this.packetFormat = data().deepCopy(fields()[3].schema(), other.packetFormat);
                fieldSetFlags()[3] = other.fieldSetFlags()[3];
            }
            if (isValidValue(fields()[4], other.packetId)) {
                this.packetId = data().deepCopy(fields()[4].schema(), other.packetId);
                fieldSetFlags()[4] = other.fieldSetFlags()[4];
            }
            if (isValidValue(fields()[5], other.packetVersion)) {
                this.packetVersion = data().deepCopy(fields()[5].schema(), other.packetVersion);
                fieldSetFlags()[5] = other.fieldSetFlags()[5];
            }
            if (isValidValue(fields()[6], other.playerCarIndex)) {
                this.playerCarIndex = data().deepCopy(fields()[6].schema(), other.playerCarIndex);
                fieldSetFlags()[6] = other.fieldSetFlags()[6];
            }
            if (isValidValue(fields()[7], other.secondaryPlayerCarIndex)) {
                this.secondaryPlayerCarIndex = data().deepCopy(fields()[7].schema(), other.secondaryPlayerCarIndex);
                fieldSetFlags()[7] = other.fieldSetFlags()[7];
            }
            if (isValidValue(fields()[8], other.sessionTime)) {
                this.sessionTime = data().deepCopy(fields()[8].schema(), other.sessionTime);
                fieldSetFlags()[8] = other.fieldSetFlags()[8];
            }
            if (isValidValue(fields()[9], other.sessionUID)) {
                this.sessionUID = data().deepCopy(fields()[9].schema(), other.sessionUID);
                fieldSetFlags()[9] = other.fieldSetFlags()[9];
            }
        }

        /**
         * Creates a Builder by copying an existing PacketHeader instance
         * @param other The existing instance to copy.
         */
        private Builder(com.jordanupmc.publisher.dto.PacketHeader other) {
            super(SCHEMA$, MODEL$);
            if (isValidValue(fields()[0], other.frameIdentifier)) {
                this.frameIdentifier = data().deepCopy(fields()[0].schema(), other.frameIdentifier);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.gameMajorVersion)) {
                this.gameMajorVersion = data().deepCopy(fields()[1].schema(), other.gameMajorVersion);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.gameMinorVersion)) {
                this.gameMinorVersion = data().deepCopy(fields()[2].schema(), other.gameMinorVersion);
                fieldSetFlags()[2] = true;
            }
            if (isValidValue(fields()[3], other.packetFormat)) {
                this.packetFormat = data().deepCopy(fields()[3].schema(), other.packetFormat);
                fieldSetFlags()[3] = true;
            }
            if (isValidValue(fields()[4], other.packetId)) {
                this.packetId = data().deepCopy(fields()[4].schema(), other.packetId);
                fieldSetFlags()[4] = true;
            }
            if (isValidValue(fields()[5], other.packetVersion)) {
                this.packetVersion = data().deepCopy(fields()[5].schema(), other.packetVersion);
                fieldSetFlags()[5] = true;
            }
            if (isValidValue(fields()[6], other.playerCarIndex)) {
                this.playerCarIndex = data().deepCopy(fields()[6].schema(), other.playerCarIndex);
                fieldSetFlags()[6] = true;
            }
            if (isValidValue(fields()[7], other.secondaryPlayerCarIndex)) {
                this.secondaryPlayerCarIndex = data().deepCopy(fields()[7].schema(), other.secondaryPlayerCarIndex);
                fieldSetFlags()[7] = true;
            }
            if (isValidValue(fields()[8], other.sessionTime)) {
                this.sessionTime = data().deepCopy(fields()[8].schema(), other.sessionTime);
                fieldSetFlags()[8] = true;
            }
            if (isValidValue(fields()[9], other.sessionUID)) {
                this.sessionUID = data().deepCopy(fields()[9].schema(), other.sessionUID);
                fieldSetFlags()[9] = true;
            }
        }

        /**
         * Gets the value of the 'frameIdentifier' field.
         * @return The value.
         */
        public long getFrameIdentifier() {
            return frameIdentifier;
        }


        /**
         * Sets the value of the 'frameIdentifier' field.
         * @param value The value of 'frameIdentifier'.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder setFrameIdentifier(long value) {
            validate(fields()[0], value);
            this.frameIdentifier = value;
            fieldSetFlags()[0] = true;
            return this;
        }

        /**
         * Checks whether the 'frameIdentifier' field has been set.
         * @return True if the 'frameIdentifier' field has been set, false otherwise.
         */
        public boolean hasFrameIdentifier() {
            return fieldSetFlags()[0];
        }


        /**
         * Clears the value of the 'frameIdentifier' field.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder clearFrameIdentifier() {
            fieldSetFlags()[0] = false;
            return this;
        }

        /**
         * Gets the value of the 'gameMajorVersion' field.
         * @return The value.
         */
        public int getGameMajorVersion() {
            return gameMajorVersion;
        }


        /**
         * Sets the value of the 'gameMajorVersion' field.
         * @param value The value of 'gameMajorVersion'.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder setGameMajorVersion(int value) {
            validate(fields()[1], value);
            this.gameMajorVersion = value;
            fieldSetFlags()[1] = true;
            return this;
        }

        /**
         * Checks whether the 'gameMajorVersion' field has been set.
         * @return True if the 'gameMajorVersion' field has been set, false otherwise.
         */
        public boolean hasGameMajorVersion() {
            return fieldSetFlags()[1];
        }


        /**
         * Clears the value of the 'gameMajorVersion' field.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder clearGameMajorVersion() {
            fieldSetFlags()[1] = false;
            return this;
        }

        /**
         * Gets the value of the 'gameMinorVersion' field.
         * @return The value.
         */
        public int getGameMinorVersion() {
            return gameMinorVersion;
        }


        /**
         * Sets the value of the 'gameMinorVersion' field.
         * @param value The value of 'gameMinorVersion'.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder setGameMinorVersion(int value) {
            validate(fields()[2], value);
            this.gameMinorVersion = value;
            fieldSetFlags()[2] = true;
            return this;
        }

        /**
         * Checks whether the 'gameMinorVersion' field has been set.
         * @return True if the 'gameMinorVersion' field has been set, false otherwise.
         */
        public boolean hasGameMinorVersion() {
            return fieldSetFlags()[2];
        }


        /**
         * Clears the value of the 'gameMinorVersion' field.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder clearGameMinorVersion() {
            fieldSetFlags()[2] = false;
            return this;
        }

        /**
         * Gets the value of the 'packetFormat' field.
         * @return The value.
         */
        public int getPacketFormat() {
            return packetFormat;
        }


        /**
         * Sets the value of the 'packetFormat' field.
         * @param value The value of 'packetFormat'.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder setPacketFormat(int value) {
            validate(fields()[3], value);
            this.packetFormat = value;
            fieldSetFlags()[3] = true;
            return this;
        }

        /**
         * Checks whether the 'packetFormat' field has been set.
         * @return True if the 'packetFormat' field has been set, false otherwise.
         */
        public boolean hasPacketFormat() {
            return fieldSetFlags()[3];
        }


        /**
         * Clears the value of the 'packetFormat' field.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder clearPacketFormat() {
            fieldSetFlags()[3] = false;
            return this;
        }

        /**
         * Gets the value of the 'packetId' field.
         * @return The value.
         */
        public com.jordanupmc.publisher.dto.PacketId getPacketId() {
            return packetId;
        }


        /**
         * Sets the value of the 'packetId' field.
         * @param value The value of 'packetId'.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder setPacketId(com.jordanupmc.publisher.dto.PacketId value) {
            validate(fields()[4], value);
            this.packetId = value;
            fieldSetFlags()[4] = true;
            return this;
        }

        /**
         * Checks whether the 'packetId' field has been set.
         * @return True if the 'packetId' field has been set, false otherwise.
         */
        public boolean hasPacketId() {
            return fieldSetFlags()[4];
        }


        /**
         * Clears the value of the 'packetId' field.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder clearPacketId() {
            packetId = null;
            fieldSetFlags()[4] = false;
            return this;
        }

        /**
         * Gets the value of the 'packetVersion' field.
         * @return The value.
         */
        public int getPacketVersion() {
            return packetVersion;
        }


        /**
         * Sets the value of the 'packetVersion' field.
         * @param value The value of 'packetVersion'.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder setPacketVersion(int value) {
            validate(fields()[5], value);
            this.packetVersion = value;
            fieldSetFlags()[5] = true;
            return this;
        }

        /**
         * Checks whether the 'packetVersion' field has been set.
         * @return True if the 'packetVersion' field has been set, false otherwise.
         */
        public boolean hasPacketVersion() {
            return fieldSetFlags()[5];
        }


        /**
         * Clears the value of the 'packetVersion' field.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder clearPacketVersion() {
            fieldSetFlags()[5] = false;
            return this;
        }

        /**
         * Gets the value of the 'playerCarIndex' field.
         * @return The value.
         */
        public int getPlayerCarIndex() {
            return playerCarIndex;
        }


        /**
         * Sets the value of the 'playerCarIndex' field.
         * @param value The value of 'playerCarIndex'.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder setPlayerCarIndex(int value) {
            validate(fields()[6], value);
            this.playerCarIndex = value;
            fieldSetFlags()[6] = true;
            return this;
        }

        /**
         * Checks whether the 'playerCarIndex' field has been set.
         * @return True if the 'playerCarIndex' field has been set, false otherwise.
         */
        public boolean hasPlayerCarIndex() {
            return fieldSetFlags()[6];
        }


        /**
         * Clears the value of the 'playerCarIndex' field.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder clearPlayerCarIndex() {
            fieldSetFlags()[6] = false;
            return this;
        }

        /**
         * Gets the value of the 'secondaryPlayerCarIndex' field.
         * @return The value.
         */
        public int getSecondaryPlayerCarIndex() {
            return secondaryPlayerCarIndex;
        }


        /**
         * Sets the value of the 'secondaryPlayerCarIndex' field.
         * @param value The value of 'secondaryPlayerCarIndex'.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder setSecondaryPlayerCarIndex(int value) {
            validate(fields()[7], value);
            this.secondaryPlayerCarIndex = value;
            fieldSetFlags()[7] = true;
            return this;
        }

        /**
         * Checks whether the 'secondaryPlayerCarIndex' field has been set.
         * @return True if the 'secondaryPlayerCarIndex' field has been set, false otherwise.
         */
        public boolean hasSecondaryPlayerCarIndex() {
            return fieldSetFlags()[7];
        }


        /**
         * Clears the value of the 'secondaryPlayerCarIndex' field.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder clearSecondaryPlayerCarIndex() {
            fieldSetFlags()[7] = false;
            return this;
        }

        /**
         * Gets the value of the 'sessionTime' field.
         * @return The value.
         */
        public float getSessionTime() {
            return sessionTime;
        }


        /**
         * Sets the value of the 'sessionTime' field.
         * @param value The value of 'sessionTime'.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder setSessionTime(float value) {
            validate(fields()[8], value);
            this.sessionTime = value;
            fieldSetFlags()[8] = true;
            return this;
        }

        /**
         * Checks whether the 'sessionTime' field has been set.
         * @return True if the 'sessionTime' field has been set, false otherwise.
         */
        public boolean hasSessionTime() {
            return fieldSetFlags()[8];
        }


        /**
         * Clears the value of the 'sessionTime' field.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder clearSessionTime() {
            fieldSetFlags()[8] = false;
            return this;
        }

        /**
         * Gets the value of the 'sessionUID' field.
         * @return The value.
         */
        public java.math.BigInteger getSessionUID() {
            return sessionUID;
        }


        /**
         * Sets the value of the 'sessionUID' field.
         * @param value The value of 'sessionUID'.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder setSessionUID(java.math.BigInteger value) {
            validate(fields()[9], value);
            this.sessionUID = value;
            fieldSetFlags()[9] = true;
            return this;
        }

        /**
         * Checks whether the 'sessionUID' field has been set.
         * @return True if the 'sessionUID' field has been set, false otherwise.
         */
        public boolean hasSessionUID() {
            return fieldSetFlags()[9];
        }


        /**
         * Clears the value of the 'sessionUID' field.
         * @return This builder.
         */
        public com.jordanupmc.publisher.dto.PacketHeader.Builder clearSessionUID() {
            sessionUID = null;
            fieldSetFlags()[9] = false;
            return this;
        }

        @Override
        @SuppressWarnings("unchecked")
        public PacketHeader build() {
            try {
                PacketHeader record = new PacketHeader();
                record.frameIdentifier = fieldSetFlags()[0] ? this.frameIdentifier : (java.lang.Long) defaultValue(fields()[0]);
                record.gameMajorVersion = fieldSetFlags()[1] ? this.gameMajorVersion : (java.lang.Integer) defaultValue(fields()[1]);
                record.gameMinorVersion = fieldSetFlags()[2] ? this.gameMinorVersion : (java.lang.Integer) defaultValue(fields()[2]);
                record.packetFormat = fieldSetFlags()[3] ? this.packetFormat : (java.lang.Integer) defaultValue(fields()[3]);
                record.packetId = fieldSetFlags()[4] ? this.packetId : (com.jordanupmc.publisher.dto.PacketId) defaultValue(fields()[4]);
                record.packetVersion = fieldSetFlags()[5] ? this.packetVersion : (java.lang.Integer) defaultValue(fields()[5]);
                record.playerCarIndex = fieldSetFlags()[6] ? this.playerCarIndex : (java.lang.Integer) defaultValue(fields()[6]);
                record.secondaryPlayerCarIndex = fieldSetFlags()[7] ? this.secondaryPlayerCarIndex : (java.lang.Integer) defaultValue(fields()[7]);
                record.sessionTime = fieldSetFlags()[8] ? this.sessionTime : (java.lang.Float) defaultValue(fields()[8]);
                record.sessionUID = fieldSetFlags()[9] ? this.sessionUID : (java.math.BigInteger) defaultValue(fields()[9]);
                return record;
            } catch (org.apache.avro.AvroMissingFieldException e) {
                throw e;
            } catch (java.lang.Exception e) {
                throw new org.apache.avro.AvroRuntimeException(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumWriter<PacketHeader>
            WRITER$ = (org.apache.avro.io.DatumWriter<PacketHeader>) MODEL$.createDatumWriter(SCHEMA$);

    @Override
    public void writeExternal(java.io.ObjectOutput out)
            throws java.io.IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumReader<PacketHeader>
            READER$ = (org.apache.avro.io.DatumReader<PacketHeader>) MODEL$.createDatumReader(SCHEMA$);

    @Override
    public void readExternal(java.io.ObjectInput in)
            throws java.io.IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

    @Override
    protected boolean hasCustomCoders() {
        return true;
    }

    @Override
    public void customEncode(org.apache.avro.io.Encoder out)
            throws java.io.IOException {
        out.writeLong(this.frameIdentifier);

        out.writeInt(this.gameMajorVersion);

        out.writeInt(this.gameMinorVersion);

        out.writeInt(this.packetFormat);

        out.writeEnum(this.packetId.ordinal());

        out.writeInt(this.packetVersion);

        out.writeInt(this.playerCarIndex);

        out.writeInt(this.secondaryPlayerCarIndex);

        out.writeFloat(this.sessionTime);

        out.writeString(this.sessionUID.toString());

    }

    @Override
    public void customDecode(org.apache.avro.io.ResolvingDecoder in)
            throws java.io.IOException {
        org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
        if (fieldOrder == null) {
            this.frameIdentifier = in.readLong();

            this.gameMajorVersion = in.readInt();

            this.gameMinorVersion = in.readInt();

            this.packetFormat = in.readInt();

            this.packetId = com.jordanupmc.publisher.dto.PacketId.values()[in.readEnum()];

            this.packetVersion = in.readInt();

            this.playerCarIndex = in.readInt();

            this.secondaryPlayerCarIndex = in.readInt();

            this.sessionTime = in.readFloat();

            this.sessionUID = new java.math.BigInteger(in.readString());

        } else {
            for (int i = 0; i < 10; i++) {
                switch (fieldOrder[i].pos()) {
                    case 0:
                        this.frameIdentifier = in.readLong();
                        break;

                    case 1:
                        this.gameMajorVersion = in.readInt();
                        break;

                    case 2:
                        this.gameMinorVersion = in.readInt();
                        break;

                    case 3:
                        this.packetFormat = in.readInt();
                        break;

                    case 4:
                        this.packetId = com.jordanupmc.publisher.dto.PacketId.values()[in.readEnum()];
                        break;

                    case 5:
                        this.packetVersion = in.readInt();
                        break;

                    case 6:
                        this.playerCarIndex = in.readInt();
                        break;

                    case 7:
                        this.secondaryPlayerCarIndex = in.readInt();
                        break;

                    case 8:
                        this.sessionTime = in.readFloat();
                        break;

                    case 9:
                        this.sessionUID = new java.math.BigInteger(in.readString());
                        break;

                    default:
                        throw new java.io.IOException("Corrupt ResolvingDecoder.");
                }
            }
        }
    }
}









