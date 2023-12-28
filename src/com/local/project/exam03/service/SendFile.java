package com.local.project.exam03.service;


import java.io.File;

public class SendFile {
   File file;

    public SendFile(String string) {
        file = new File(string);
        if (file.exists()) {
            System.out.println((getFileSizeMegaBytes(file)) < 1);
            System.out.println((getFileSizeBytes(file)) == 11);
        } else System.out.println("����� ���!");
    }



        public static void main(String[] args) {
        SendFile sendFile = new SendFile("C:\\Users\\d9619\\IdeaProjects\\new-local-repository\\src\\com\\local\\project\\exam03\\client\\file_arcive_client\\info.txt");


    }
    // ����� ���������� ������ ����� � ����������
    // ����� ����� ����� �� 1 �������� (1024 * 1024 ����) � ������ ���������� ��������
    private static double getFileSizeMegaBytes(File file) {
        return (double) file.length()/(1024*1024);
    }

    // ����� ���������� ������ ����� � ����������
    // ����� ����� ����� �� 1 �������� (1024 ����) � ������ ���������� ��������
    private static String getFileSizeKiloBytes(File file) {
        return (double) file.length()/1024 + " kb";
    }

    // ������ �������� ����� length() � �������� ������ ����� � ������
    private long getFileSizeBytes(File file) {
        return (long)file.length();
    }

}
