package com.jordanupmc.udpserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.DatagramChannel;

public interface Server {
    int BUFFER_BYTES_CAPACITY = 1500;

    String HOSTNAME = "192.168.1.7";
    int PORT = 20777;

    static ByteBuffer receiveDatagram(DatagramChannel server, int bufferCapacity) throws IOException {
        ByteBuffer buffer = initBuffer(bufferCapacity);
        server.receive(buffer);
        buffer.flip();
        return buffer;
    }


    static DatagramChannel startServer(String hostname, int port) throws IOException {
        var address = new InetSocketAddress(hostname, port);
        var datagramChannel = DatagramChannel.open();
        var server = datagramChannel.bind(address);
        System.out.println("Server started at #" + address);
        return server;
    }

    static ByteBuffer initBuffer(int bufferCapacity) {
        return ByteBuffer
                .allocate(bufferCapacity)
                .order(ByteOrder.LITTLE_ENDIAN);
    }
}
