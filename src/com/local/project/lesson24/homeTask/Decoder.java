package com.local.project.lesson24.homeTask;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


public class Decoder extends FilterInputStream {
    public Decoder(InputStream input) {
        super(input);
    }
    @Override
    public int read() throws IOException {
        return super.in.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        System.out.println("before decoding " + Arrays.toString(b));
        byte[] result  = new byte[b.length];
        String keyWord = "code";
        byte[] arrKeyWords = keyWord.getBytes();
        for (int i = 0; i < b.length; i++) {
            result[i] = (byte) (b[i] ^ arrKeyWords[i % arrKeyWords.length]);
        }
        System.out.println("after decoding  " + Arrays.toString(result));
        return super.read(result, 0, result.length);
    }
}
