package com.jordanupmc.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

class ByteBufferHelperTest {

    private ByteBuffer buffer;

    @BeforeEach
    void init() {
        buffer = ByteBuffer.allocate(128);
    }

    @Test
    void getUnsignedByte_should_return_short() {
        // given
        putInBuffer(Byte.MAX_VALUE, buffer::put);
        // when
        short unsignedByte = ByteBufferHelper.getUnsignedByte(buffer);
        // then
        assertThat(unsignedByte).isEqualTo(Byte.MAX_VALUE);
    }

    @Test
    void getByte_should_return_signed_short() {
        // given
        putInBuffer((byte) -65, buffer::put);
        // when
        short unsignedByte = ByteBufferHelper.getByte(buffer);
        // then
        assertThat(unsignedByte).isEqualTo((short) -65);
    }

    @Test
    void getUnsignedShort_should_return_int() {
        // given
        putInBuffer(Short.MAX_VALUE, buffer::putShort);
        // when
        int unsignedByte = ByteBufferHelper.getUnsignedShort(buffer);
        // then
        assertThat(unsignedByte).isEqualTo(Short.MAX_VALUE);
    }

    @Test
    void getUnsignedInt_should_return_long() {
        // given
        putInBuffer(Integer.MAX_VALUE, buffer::putInt);
        // when
        long unsignedByte = ByteBufferHelper.getUnsignedInt(buffer);
        // then
        assertThat(unsignedByte).isEqualTo(Integer.MAX_VALUE);
    }


    @Test
    void getFloat_should_return_float() {
        // given
        putInBuffer(Float.MAX_VALUE, buffer::putFloat);
        // when
        float unsignedByte = ByteBufferHelper.getFloat(buffer);
        // then
        assertThat(unsignedByte).isEqualTo(Float.MAX_VALUE);
    }

    @Test
    void getFloat_should_return_signed_float() {
        // given
        putInBuffer((float) -6.36, buffer::putFloat);
        // when
        float unsignedByte = ByteBufferHelper.getFloat(buffer);
        // then
        assertThat(unsignedByte).isEqualTo((float) -6.36);
    }

    @Test
    void getUnsignedLong_should_return_float() {
        // given
        putInBuffer(Long.MAX_VALUE, buffer::putLong);
        // when
        BigInteger unsignedByte = ByteBufferHelper.getUnsignedLong(buffer);
        // then
        assertThat(unsignedByte).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    void getUnsignedByte_should_return_246_when_buffer_is_negative_10() {
        // given
        putInBuffer((byte) -10, buffer::put);
        // when
        short unsignedByte = ByteBufferHelper.getUnsignedByte(buffer);
        // then
        assertThat(unsignedByte).isEqualTo((short) 246);
    }

    @Test
    void getUnsignedShort_should_return_65526_when_buffer_is_negative_10() {
        // given
        putInBuffer((short) -10, buffer::putShort);
        // when
        int unsignedShort = ByteBufferHelper.getUnsignedShort(buffer);
        // then
        assertThat(unsignedShort).isEqualTo(65526);
    }

    @Test
    void getUnsignedInt_should_return_4294967286_when_buffer_is_negative_10() {
        // given
        putInBuffer(-10, buffer::putInt);
        // when
        long unsignedInt = ByteBufferHelper.getUnsignedInt(buffer);
        // then
        assertThat(unsignedInt).isEqualTo(4294967286L);
    }

    @Test
    void getUnsignedLong_should_return_18446744073709551606_when_buffer_is_negative_10() {
        // given
        putInBuffer(-10L, buffer::putLong);
        // when
        BigInteger bigInteger = ByteBufferHelper.getUnsignedLong(buffer);
        // then
        assertThat(bigInteger).isEqualTo(new BigInteger("18446744073709551606"));
    }

    private <T> void putInBuffer(T x, Consumer<T> consumer) {
        consumer.accept(x);
        buffer.flip();
    }
}