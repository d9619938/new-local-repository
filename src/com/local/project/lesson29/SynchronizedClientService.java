package com.local.project.lesson29;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedClientService extends Thread {
        private final List<String> tokens;
        // аналог synchronized
        private ReentrantLock reentrantLock;
        // Semaphore - разрешение на доступ к одному ресурсу
        private Semaphore semaphore;


        public SynchronizedClientService(List<String> tokens, ReentrantLock reentrantLock,
                                         Semaphore semaphore) {
            this.tokens = tokens;
            this.reentrantLock = reentrantLock;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            String token;
//            reentrantLock.isLocked() ресурс уже заблокирован boolean
//            reentrantLock.getQueueLength() очередь за ресурсом
//            boolean isLocked = reentrantLock.tryLock(100, TimeUnit.MILLISECONDS);
//            isLocked - true, удалось получить блокировку
//            isLocked - false, ресурс не был освобожден за 100 MILLISECONDS

            try {
                semaphore.acquire(/*2*/); // поток запрашивает разрешение у семафора,
                                            // в скобках указываем количество разрешений
                                            // на этом моменте блокируется разрешение доступа Семафором
                                            // метод уменьшает счетчик semaphore


                reentrantLock.lock(); // тут происходит блокировка ресурса
//                token = tokens.removeLast();
                token = tokens.remove(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                reentrantLock.unlock(); // в блоке finally разблокировали
            }

            String newToken = makeRequest(token);
            synchronized (tokens) {
                tokens.add(newToken);
            }
            semaphore.release();            // метод увеличивает счетчик semaphore, сколько взяли, столько нужно отдать!

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
