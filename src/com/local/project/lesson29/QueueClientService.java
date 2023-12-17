package com.local.project.lesson29;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueClientService implements Runnable{
    private ArrayBlockingQueue<String> tokens;

    public QueueClientService(ArrayBlockingQueue<String> tokens) {
        this.tokens = tokens;
    }

    @Override
    public void run() {
        try{
//            блокирующие методы отличающие блокирующую очередь от обычной
//            take()    удаляет элемент из начала очереди и возвращает его., если элемента нет, то поток останавливается
//                      на моменте вызова метода take(), до тех пор пока в очереди не появится элемент
//            put()     возвращает элемент в конец очереди, если места в очереди нет, то поток будет заблокирован, пока место не освободится
            String token = tokens.take();
            String newToken = makeRequest(token);
            tokens.put(newToken);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private String makeRequest(String token) {
        try {
            System.out.println(Thread.currentThread().getName() +
                    " connected with token " + token);
            Thread.sleep(10_000);
            return UUID.randomUUID().toString();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}