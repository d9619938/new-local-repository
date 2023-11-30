package com.local.project.lesson24.homeTask;

import java.io.*;
import java.util.Arrays;

public class HomeTask24 {
    // ## Реализовать декораторы для `InputStream` и `OutputStream`, которые шифруют и дешифруют байты (^)XOR шифрованием.
    //Декораторы должны наследоваться от `FilterInputStream` и `FilterOutputStream`.


    public static void main(String[] args) {

        byte[] bytes;
        try (FileInputStream fis = new FileInputStream("D:\\JAVA\\test\\code_test.txt")) {
            bytes = new byte[fis.available()];
            System.out.println(Arrays.toString(bytes));
            fis.read(bytes);
            System.out.println(Arrays.toString(bytes));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        byte[] copy = bytes;
        try (Coder coder = new Coder(new FilterOutputStream(new FileOutputStream("D:\\JAVA\\test\\code_test01.txt")))) {
            coder.write(copy);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        byte[] bytes1;
        try (Decoder decoder = new Decoder(new FileInputStream("D:\\JAVA\\test\\code_test01.txt"))) {
            bytes1 = new byte[decoder.available()];
            decoder.read(bytes1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
