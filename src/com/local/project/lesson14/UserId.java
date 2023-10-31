package com.local.project.lesson14;

public class UserId<T> {
    private T id;
    private String userName;

    public UserId(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args) {
        UserId<Integer> userId01 = new UserId<>(2);
        UserId<String> userId02 = new UserId<>("����");
        userId02.setId(userId02.getId().toLowerCase());

        // �������������� ��� /����� / raw ���
        UserId rawUser = new UserId("12");
        rawUser.setId(12);
        rawUser.setId(userId02);
        System.out.println(rawUser.getId().toString());
    }
}

//class Admin extends UserId<Integer> {}   // ����� ��������� ������� ����� �������� ���
//class Admin<T> extends UserId<T> {}      // ����� ��������� ��� ��� ��������� ����� ������ �� ���� ��� ��������
//class Admin<T, K> extends UserId<T> {    // ����� ���� ��� ���� � ����������
//    private T user;
//    private K code;
//}
