package com.local.project.exam03.client;

import java.net.InetSocketAddress;

public class ClientApp {
    public static void main (String[] args) {
        InetSocketAddress remoteAddress = new InetSocketAddress("127.0.0.1", 4000);
        Client client = new Client(remoteAddress);
        client.run();
    }

}
