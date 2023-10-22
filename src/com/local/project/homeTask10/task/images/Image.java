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
    public Image clone() throws CloneNotSupportedException {
        return (Image) super.clone();
    }
}
