package com.local.project.lesson1516.customlist;

import java.util.Objects;

public class Point implements Comparable<Point> {

    @Override
    public int compareTo(Point o) {
        // 0 если объекты равны
        // -1 если вызывающий объект меньше
        // 1 если вызывающий объект больше
        if (this.x == o.x && this.y == o.y) return 0;
        else if (this.x > o.x && this.y > o.y) return 1;
        else if (this.x == o.x && this.y > o.y) return 1;
        else if (this.x > o.x && this.y == o.y) return 1;
        else if (this.x < o.x && this.y == o.y) return -1;
        else if (this.x < o.x && this.y < o.y) return -1;
        return 0;
    }

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return getX() == point.getX() && getY() == point.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
