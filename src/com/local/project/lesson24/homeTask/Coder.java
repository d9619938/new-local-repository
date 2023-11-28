package com.local.project.lesson24.homeTask;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class Coder extends FilterOutputStream {

    public Coder(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        super.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        String keyWord = "code";
        byte[] arrKeyWords = keyWord.getBytes();
        byte[] result = new byte[b.length];
        System.out.println("before coding " + Arrays.toString(b));
        for (int i = 0; i < b.length; i++) {
            result[i] = (byte) (b[i]^arrKeyWords[i % arrKeyWords.length]);
        }
        System.out.println("after coding  " + Arrays.toString(result));
        super.write(result, 0, result.length);
    }

}
