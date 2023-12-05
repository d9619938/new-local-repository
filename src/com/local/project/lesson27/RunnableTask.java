package com.local.project.lesson27;

public class RunnableTask implements Runnable{

private String string;

    public RunnableTask(String string) {
        this.string = string;
    }
    public void print(){
        System.out.println(string);
    }

    @Override
    public void run() {
     print();
    }
}
