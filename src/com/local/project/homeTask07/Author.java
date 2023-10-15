package com.local.project.homeTask07;

public class Author {
    // свойства, поля, атрибуты
    // модификатор public - свойство, конструктор, метод доступны в любом участке программы
    public long id; // значение по умолчанию 0 (как и для всех целых чисел)
    public String name; // значение по умолчанию null (как и для всех ссылочных типов)

    public Author(){}
    // инструкции конструктора выполняются при создании объекта
    // конструкторы могут быть перегружены (в классе можно объявить несколько конструкторов)
    // перегруженные конструкторы должны различаться типами и количеством аргументов
    public Author(long authorId){
        this.id = authorId;
    }

    public Author(long authorId, String name){
        this(authorId); // вызов другого конструктора должен быть первым
        this.name = name;
    }

    // методы
    // void - метод выполняет инструкции, но ничего не возвращает
    public void printInfo(){
        System.out.println("Автор: id= " + id + ", name= " + name);
    }
    // String - метод выполняет инструкции, и возвращает значение указанного типа (в данном случае String)
    public String getInfo(){
        // return прерывает работу метода и возвращает результат
        return "Автор: id= " + id + ", name= " + name;
    }
    public void getInfo(String prefix){
        if (prefix == null) return; // прерывает работу метода
        System.out.print(prefix + "Автор: id= " + id + ", name= " + name);
    }
}