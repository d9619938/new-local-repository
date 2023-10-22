package com.local.project.homeTask10.task.images;

public final class Editor implements Cloneable {
    private Drawable drawable;

    public Editor(Drawable drawable) { // конструктор
        setDrawable(drawable);
    }

    public void setDrawable(final Drawable drawable){
        this.drawable = drawable;
    }

    public void show(){
        drawable.draw();
    }
//    public Drawable getDrawable() {
//        return drawable;
//    }
//    @Override
//    public Editor clone() throws CloneNotSupportedException {
//        Editor editorClone = (Editor) super.clone();
//        editorClone.setDrawable(drawable);
//        return editorClone;
//    }


    @Override
    // В этом решении, хоть и создаю новый объект, но кажется клонирование все-равно не глубокое, т.к. в Gallery
    // свойства ссылочного типа, но при этом вывод в консоль показывает что ссылки на объекты не равны и
    // изменение свойств одного из объектов не влечет за собой изменение свойств остальных копий или оригинала.
    public Editor clone() throws CloneNotSupportedException {
        Editor editorClone = null;
        if (drawable instanceof Image) {
        editorClone = new Editor(((Image) drawable).clone());
    } else if (drawable instanceof Gallery) {
            editorClone = new Editor(((Gallery) drawable).clone());
            }
        return  editorClone;
        }

}
