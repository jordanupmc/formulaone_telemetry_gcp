package com.jordanupmc.publisher;

import com.jordanupmc.core.packet.Packet;

import java.io.IOException;
import java.util.concurrent.Future;

public interface PacketPublisher<P extends Packet> {
    Future<String> publish(P packet) throws IOException;
}
