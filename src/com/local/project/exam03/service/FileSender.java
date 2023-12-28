package com.local.project.exam03.service;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class FileSender {
    private String description;
    private String fileName;
    private String fileDirectory;
    private File patch;
    private final int MaxFileSizeMb;

    public FileSender(String description, String fileName, String fileDirectory) {
        this.description = description;
        this.fileName = fileName;
        this.fileDirectory = fileDirectory;
        this.patch = new File(fileDirectory + "\\" + fileName);
        MaxFileSizeMb = 1;
    }

    public String getDescription() {
        return description;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileDirectory() {
        return fileDirectory;
    }

    public File getPatch() {
        return patch;
    }

    protected byte[] readFile (File patch) throws IOException {
        Objects.requireNonNull(patch, "file not null");
        try (FileInputStream reader = new FileInputStream(patch)) {
            return reader.readAllBytes();
        } catch (FileNotFoundException e) {
            System.out.println("���� �� ������");
            System.out.println(e.getMessage());
        }
        return null;
    }
    protected void writeFile (File patch, byte[] bytes) {
        Objects.requireNonNull(patch, "bytes not null");
        if (patch.isFile() && getFileSizeMegaBytes(patch) < MaxFileSizeMb) {
            try (FileOutputStream writer = new FileOutputStream(patch)){
                writer.write(bytes);
            } catch (FileNotFoundException e) {
                System.out.println("���� �� ������");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected double getFileSizeMegaBytes(File file) {
        return (double) file.length()/(1024*1024);
    }

    public static void main(String[] args) {
        FileSender sender = new FileSender("�������� ����",
                "test.txt", "C:\\Users\\d9619\\IdeaProjects\\new-local-repository\\src\\com\\local\\project\\exam03\\service");
        try {
            byte[] bTest = sender.readFile(sender.getPatch());
            System.out.println(Arrays.toString(bTest));

            sender.writeFile(new File("C:\\Users\\d9619\\IdeaProjects\\new-local-repository\\src\\com\\local\\project\\exam03\\service\\test_2.txt"), );
        } catch (IOException e) {
            System.out.println("������ ������ �����");
            throw new RuntimeException(e);
        }
    }
}

