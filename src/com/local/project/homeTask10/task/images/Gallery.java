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
        galleryClone.drawables = new Drawable[drawables.length];  // �������
        for (int i = 0; i < galleryClone.drawables.length; i++) { // ��������������� ��������� �������
            galleryClone.drawables[i] = getDrawables()[i];        // ������������, �.�. � �������� �������� ������� ������
                                                                //getDrawables()[i].clone() - ������, ������������ ���������
                                                                //((Gallery)getDrawables()[i]).clone() - �lassCastExeption
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
