package com.local.project.lesson09;

public class Department {

    private String name;

    protected int numberOfWorkers;

    private Department head;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public Department getHead() {
        return head;
    }

    public void setHead(Department head) {
        this.head = head;
    }

    public static void main(String[] args) {
        Department department01 = new Department();
        Department department02 = new Department();
        Department department03 = new Department();
        Department department04 = new Department();
        Department department05 = new Department();
        Department department06 = new Department();
        Department department07 = new Department();

        department01.setName("Директор");
        department01.setNumberOfWorkers(1);

        department02.setName("Дирекция по продажам");
        department02.setNumberOfWorkers(5);
        department02.setHead(department01);

        department03.setName("Отдел продаж");
        department03.setNumberOfWorkers(15);
        department03.setHead(department02);

        department04.setName("Отдел рекламы и PR");
        department04.setNumberOfWorkers(7);
        department04.setHead(department02);

        department05.setName("Дирекция по экономике и финансам");
        department05.setNumberOfWorkers(6);
        department05.setHead(department01);

        department06.setName("Отдел кадров");
        department06.setNumberOfWorkers(10);
        department06.setHead(department05);

        department07.setName("Бухгалтерия");
        department07.setNumberOfWorkers(13);
        department07.setHead(department05);




    }
}
