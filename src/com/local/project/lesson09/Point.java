package com.local.project.lesson09;
// final
public /*final*/ class Point { // наследование запрещено, чтобы не ломали реализацию методов, не сломать программу
    private final int x = 33;  // запрет дальнейшего изменения переменной
    private int y;

    public final void printInfo () {}; // запрет на изменение метода

    public Point (final int y) {
//        y = 0; // значение не изменить...ссылку не изменить
        this.y = y;

    }

}
