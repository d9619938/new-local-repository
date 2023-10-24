package com.local.project.homeTask10.task.images;


public class Image implements Drawable, Cloneable {
    private String path;

    public Image(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public void draw() {
        System.out.println(path);
    }

    @Override
    public Drawable clone()  {
        try {
            return (Image) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
