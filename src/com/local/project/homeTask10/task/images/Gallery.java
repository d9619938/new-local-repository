package com.local.project.homeTask10.task.images;


public class Gallery implements Drawable {
    private String name;
    private Drawable[] drawables;

    public Gallery(String name, Drawable[] drawables) {
        this.drawables = drawables;
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println(name);
        for (Drawable drawable : drawables) {
            drawable.draw();
        }

    }
}
