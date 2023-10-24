package com.local.project.homeTask10.task.images;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Editor editor01 = new Editor(new Image("\"D:\\rose.png\""));
        Editor editor02 = new Editor(new Gallery("Галерея",
                new Drawable[]{new Image("\"D:\\horse.png\""), new Image("\"D:\\pig.png\"")}));

        Editor[] editorsImage = copyTwoEditor(editor01);
        Editor[] editorsGallery = copyTwoEditor(editor02);
        printInfo(editor01, editorsImage);
        System.out.println();
        printInfo(editor02, editorsGallery);

        System.out.println();
        editor01.setDrawable(new Image("\"D:\\PION.png\""));
        printInfo(editor01, editorsImage);
        System.out.println();
        editorsGallery[1].setDrawable(new Gallery("ZOO",
                new Drawable[]{new Image("\"D:\\MONKEY.png\""), new Image("\"D:\\ELEPHANT.png\"")}));
        printInfo(editor02, editorsGallery);

    }

    private static void printInfo(Editor editor, Editor[] editors) {
        System.out.println(editor);
        for (Editor e : editors) {
            System.out.println(e);
        }
        editor.show();
        editors[0].show();
        editors[1].show();
        System.out.println("Are tree links equal: " + (editor == editors[0]) +" "+ (editor == editors[1]) + " " + (editors[0] == editors[1]));

    }

    private static Editor[] copyTwoEditor(Editor editor) throws CloneNotSupportedException {
        Editor[] editors = new Editor[2];
        for (int i = 0; i < editors.length; i++) {
            editors[i] = editor.clone();
        }
        return editors;
    }
}
