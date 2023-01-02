package com.jordanupmc.udpserver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UdpSessionRecorder implements Server {

    private static final String FILE_NAME = getFileName();


    public static void main(String[] args) {
        try (var datagramChannel = Server.startServer(HOSTNAME, PORT)) {
            while (true) {
                handleDatagram(datagramChannel);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void handleDatagram(DatagramChannel server) throws IOException {
        ByteBuffer buffer = Server.receiveDatagram(server, BUFFER_BYTES_CAPACITY);
        try (var fos = new FileOutputStream(FILE_NAME, true)) {
            fos.write(buffer.array());
        }
    }

    private static String getFileName() {
        return "udp_record_" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

}