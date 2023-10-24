package com.local.project.lesson11;

public class Article {
    private County county;  // null может быть изначально

    public Article(County county) {
        this.county = county;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }
}
