package com.local.project.lesson24.homeTask;

import java.io.*;
import java.util.Arrays;

public class HomeTaskValue2 {
    static String string = "������������� ��������";
    static String key = "����";
    static byte[] bytes01;
    static byte[] bytes02;

    public static void main(String... s) {
        bytes01 = string.getBytes();

        try(FileOutputStream fos = new FileOutputStream("D:\\JAVA\\test\\code_test04.txt");
        Cryptographer cryptographer = new Cryptographer(fos, key)) {
            cryptographer.write(bytes01);
        } catch (FileNotFoundException e) {
            System.out.println("������ ������� � �����");
        } catch (IOException e) {
            System.out.println("������ ������ � ����");
        }

        try(FileInputStream fis = new FileInputStream("D:\\JAVA\\test\\code_test04.txt");
            Decryptor decryptor = new Decryptor(fis, key)){
            bytes02 = new byte[fis.available()];
            decryptor.read(bytes02);
        } catch (FileNotFoundException e) {
        System.out.println("������ ������� � �����");
    } catch (IOException e) {
        System.out.println("������ ������ �� �����");
    }

    }
    public static class Cryptographer extends FilterOutputStream {
    private String key;
        public Cryptographer(OutputStream out, String key) {
            super(out);
            this.key = key;
        }

        @Override
        public void write(byte[] b) throws IOException {
            System.out.println("�� ����������: ������ - \"" + new String(b) + "\"; ������ ���� -" + Arrays.toString(b) );
            int crypt = key.length();
            byte[] result = new byte[b.length];
            for (int i = 0; i < b.length; i++) {
                result[i] = (byte) (b[i] ^ crypt);
            }
            System.out.println("����� ����������: ������ - \"" + new String(result) + "\"; ������ ���� -" + Arrays.toString(result) );
            super.write(result);
        }
    }

    public static class Decryptor extends FilterInputStream {
    private String key;
        protected Decryptor(InputStream in, String key) {
            super(in);
            this.key = key;
        }

        @Override
        public int read(byte[] b) throws IOException {
            int read = super.read(b);
            System.out.println("�� �������������: ������ - \"" + new String(b) + "\"; ������ ���� -" + Arrays.toString(b) );
            int crypt = key.length();
            byte[] result = new byte[b.length];
            for (int i = 0; i < b.length; i++) {
                result[i] = (byte) (b[i] ^ crypt);
            }
            System.out.println("����� �������������: ������ - \"" + new String(result) + "\"; ������ ���� -" + Arrays.toString(result) );
            return read;

        }
    }
}
