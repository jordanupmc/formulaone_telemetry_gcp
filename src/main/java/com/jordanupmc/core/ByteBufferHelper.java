package com.jordanupmc.core;

import java.math.BigInteger;
import java.nio.ByteBuffer;

public class ByteBufferHelper {
    public static short getUnsignedByte(ByteBuffer buffer) {
        return ((short) (buffer.get() & 0xff));
    }
    public static byte getByte(ByteBuffer buffer) {
        return buffer.get();
    }

    public static int getUnsignedShort(ByteBuffer buffer) {
        return Short.toUnsignedInt(buffer.getShort());
    }

    public static long getUnsignedInt(ByteBuffer buffer) {
        return Integer.toUnsignedLong(buffer.getInt());
    }

    public static float getFloat(ByteBuffer buffer) {
        return buffer.getFloat();
    }

    private static final BigInteger TWO_64 = BigInteger.ONE.shiftLeft(64);

    public static BigInteger getUnsignedLong(ByteBuffer buffer) {
        BigInteger bigInteger = BigInteger.valueOf(buffer.getLong());
        if (bigInteger.signum() < 0) {
            bigInteger = bigInteger.add(TWO_64);
        }
        return bigInteger;
    }

}
