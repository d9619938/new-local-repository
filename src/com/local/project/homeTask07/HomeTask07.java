package com.local.project.homeTask07;

public class HomeTask07 {
    public static void main(String[] args) {

        Author author01 = new Author(1, "Толстой");
        Author author02 = new Author(2, "Булгаков");
        Author author03 = new Author(3, "Гоголь");
        Author author04 = new Author(4, "Достоевский");
        Author author05 = new Author(5, "Гоголь");
        Author author06 = author01;


        Book book01 = new Book("Сборник записок 01", 3);
        book01.addAddAuthor(author01);
        book01.addAddAuthor(author01);
        book01.addAddAuthor(author02);
        book01.addAddAuthor(author03);

        Book book02 = new Book("Сборник записок 02", 4);
        book02.addAddAuthor(author01);
        book02.addAddAuthor(author06);
        book02.addAddAuthor(author02);
        book02.addAddAuthor(author01);
        book02.addAddAuthor(author03);
        book02.addAddAuthor(author04);
        book02.addAddAuthor(author05);


        for (Author line:
             book01.getAuthors()) {
            line.printInfo();
        }
        System.out.println();
        for (Author line:
                book02.getAuthors()) {
            line.printInfo();
        }

    }
}
