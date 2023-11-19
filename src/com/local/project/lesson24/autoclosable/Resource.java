package com.local.project.lesson24.autoclosable;

import java.io.Closeable;
import java.io.IOException;

public class Resource implements AutoCloseable {
    public void resourceVoid() throws IOException {
    }
    public void resourceVoid01() throws IOException {
        resourceVoid();
    }
    @Override
    public void close() {
        System.out.println("логика связанная с закрытием ресурсов");
    }
}
