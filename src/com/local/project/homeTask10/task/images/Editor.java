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
    protected Drawable getDrawable() {
        return drawable;
    }
    @Override
    protected Editor clone() throws CloneNotSupportedException {
        Editor editorClone = (Editor) super.clone();
        editorClone.setDrawable(drawable);
        return editorClone;
    }
}
