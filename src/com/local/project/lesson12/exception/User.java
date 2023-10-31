package com.local.project.lesson12.exception;

public class User implements Cloneable{

    private int age;
    String name;

    public User(int age) throws Exception{
        if (age < 0) throw new ExceptionTime("hello");
            throw new IllegalArgumentException();
       // this.age = age;
    }

    @Override
    public User clone() throws CloneNotSupportedException {    //���������� ����� ���������� � ���� ����������� ������ �������
                                                                    // ����� ������� ��������� ����� ���� �������
        return (User) super.clone();
    }
}
