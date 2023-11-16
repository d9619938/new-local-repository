package com.local.project.lesson14.properties;

// T компилируется в Object
public class User<T> {
    private T id;
    private String userName;

    public User(T id) {
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
}
/*
class Admin extends User<Integer> {}
Admin admin = new Admin(1);

class Admin<T> extends User<T> {}
Admin<Integer> admin = new Admin<>(1);

class Admin<T, K> extends User<T> {
    private K code;
}
Admin<Integer, String> admin = new Admin<>(1);
*/