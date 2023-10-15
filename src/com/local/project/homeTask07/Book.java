package com.local.project.homeTask07;

public class Book {
    private String name;
    private boolean isPublished;
    private Author[] authors;

    public Book(String name, int numberOfAuthors) {
        setName(name);
        if (numberOfAuthors < 1 || numberOfAuthors >= 5) {
            throw new IllegalArgumentException("number of authors not [1, 5)");
        }
        authors = new Author[numberOfAuthors];
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        this.isPublished = published;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setName(String name){
        if (name == null) {
            throw new IllegalArgumentException("name not null");
        }
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void addAddAuthor(Author author){
        if (author == null) {
            throw new IllegalArgumentException("author not null");
        }
            for (int i = 0; i < authors.length; i++) {
                if (authors[i] == author){
                    return;
                } else if (authors[i] == null) {
                    authors[i] = author;
                    return;
                }
            }
        }

        // author не может быть null ссылкой
        // новые авторы не должны перезаписывать уже существующих в массиве
}
