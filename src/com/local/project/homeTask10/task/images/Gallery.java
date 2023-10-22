package com.local.project.homeTask10.task.images;


public class Gallery implements Drawable, Cloneable {
    private String name;
    private Drawable[] drawables;

    public Gallery(String name, Drawable[] drawables) {
        this.drawables = drawables;
        this.name = name;
    }

    public Drawable[] getDrawables() {
        return drawables;
    }

    @Override
    public Gallery clone() throws CloneNotSupportedException {
        Gallery galleryClone = (Gallery) super.clone();
        galleryClone.drawables = new Drawable[drawables.length];  // кажется
        for (int i = 0; i < galleryClone.drawables.length; i++) { // переопределение элементов массива
            galleryClone.drawables[i] = getDrawables()[i];        // бессмысленно, т.к. в элементы передаем текущие ссылки
                                                                //getDrawables()[i].clone() - ошибка, клонирование запрещено
                                                                //((Gallery)getDrawables()[i]).clone() - СlassCastExeption
        }
        return galleryClone;
    }

    @Override
    public void draw() {
        System.out.println(name);
        for (Drawable drawable : drawables) {
            drawable.draw();
        }


    }
}
