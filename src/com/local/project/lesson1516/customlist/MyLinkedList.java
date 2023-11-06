package com.local.project.lesson1516.customlist;

// двунапрвленный или однонаправленный связный список
public class MyLinkedList<T> {
    // размер списка (увеличивается при добавлении, уменьшается при удалении)
    private int size;
    // ссылка на первый элемент списка
    private MyLinkedListNode<T> first;
    // ссылка на последний элемент списка
    private MyLinkedListNode<T> last;

    // добавление элемента в список
    public void add(T t) {}

    // добавление элемента в список на указанную позицию
    // индексы начинаются с 0 и не могут быть больше или равными size
    public void add(T t, int index) {}

    // удаление элемента из списка (для установки соответствия использовать метод equals)
    // возвращает true, если элемент был удалён и false, если нет
    public boolean remove(T t) {
        return false;
    }

    // удаление элемента из списка по индексу
    // возвращает удалённый, если он был удалён и null, если нет
    public T remove(int index) {
        return null;
    }


    // получение элемента списка по индексу (без удаления)
    // возвращает ссылку на элемент, если он найден и null, если нет
    public T get(int index) {
        return null;
    }

    // метод, позволяющий развернуть список
    // необходимо перезаписать все ссылки, а не просто поменять местами first и last
    public void reverse(){}
}

