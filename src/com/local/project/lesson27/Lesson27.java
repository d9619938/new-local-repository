package com.local.project.lesson27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lesson27 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList.add("6");
        stringList.add("7");

        ThreadTask threadTask01 = new ThreadTask(stringList);
        threadTask01.setName("ThreadTask 01");
        System.out.println(threadTask01.getState()); // состояние потока
        threadTask01.setPriority(10); // можно приоритезировать, но полагаться на 100% нельзя

        ThreadTask threadTask02 = new ThreadTask(stringList);
        threadTask02.setName("ThreadTask 02");
        threadTask02.setPriority(10); // можно приоритезировать, но полагаться на 100% нельзя

//        методы можно вызвать, но инструкции не будут выполняться в отдельном потоке!!!
        threadTask01.printList(); // не будет работать в потоке threadTask
        threadTask01.run(); // не будет работать в потоке threadTask
//        threadTask.start(); // поток готов к работе и планировщик потоков запустит его, когда решит

        threadTask01.start();
        threadTask02.start();


        System.out.println("main");

        RunnableTask runnableTask = new RunnableTask("task");
        Thread threadWithRunnable = new Thread(runnableTask);
        System.out.println(threadWithRunnable.getState());
        threadWithRunnable.start();


        //СОЗДАНИЕ ПОТОКА ЧЕРЕЗ ЛЯМБДА
        // ОПИСАНИЕ метода void run(); ОН НЕ МОЖЕТ НИЧЕГО ПРИНИМАТЬ ИЛИ ВОЗВРАЩАТЬ
//        Thread threadWithLambda = new Thread(() -> {
//            // задача потока
//            while (true){
//            System.out.println(Thread.currentThread().getName());
//        }
//        });

        // ФОНОВЫЙ ПОТОК будет работать до тех пор, пока работает хотя бы один основной поток, пока не завершились инструкции
        // может ВООБЩЕ не начать работать, если все другие потоки отработали
//        threadWithLambda.setName("DEAMON");
//        threadWithLambda.setDaemon(true); // метод setDemon - преобразует поток в фоновый поток. Установить можно до метода start();
//        threadWithLambda.start();
       
        List<Double> doubles = new ArrayList<>();
        Thread addTODoubles = new Thread(()->{
//            while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());;
            }
            doubles.add(Math.random());
//            }
        });
        addTODoubles.setName("addDoubles");
        addTODoubles.start();
        try{
            //  addTODoubles.join();  // main ждет, пока addDoub закончит работу
            addTODoubles.join(1000); /// main ждет, пока addDoubles закончит работу 1000 миллисекунд
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(doubles);
        
        System.out.println("main");


        // Thread interrupted - false
        // .isInterrupted() -> false
        // .interrupt() -> interrupted -> true
        // .isInterrupted() -> true
        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()) {
                // инструкции потока
                try {
                    Thread.sleep((1000));
                } catch (InterruptedException e) {  // меняет свойство interrupted на false
                    Thread.currentThread().interrupt(); // чтобы прервать поток нужно обязательно вызвать interrupt!!!!, теперь он true
                }
            }
        });

        thread.start();
        thread.interrupt(); // меняет значение свойства isInterrupted() на true

    }
}
