package com.local.project.exam03.server;

public class ServerApp {
    public static void main(String[] args) {
        Server server = new Server(4000);
        server.run();
    }
}
