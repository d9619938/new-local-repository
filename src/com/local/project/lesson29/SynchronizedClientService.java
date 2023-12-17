package com.local.project.lesson29;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedClientService extends Thread {
        private final List<String> tokens;
        private ReentrantLock reentrantLock;   // аналог synchronized (вместо synchronized блока или метода)
        private Semaphore semaphore;   // Semaphore - разрешение на доступ к одному ресурсу

        public SynchronizedClientService(List<String> tokens, ReentrantLock reentrantLock,
                                         Semaphore semaphore) {
            this.tokens = tokens;
            this.reentrantLock = reentrantLock;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            String token;   // переменная, в которую сохраняется токен из списка

//            функции блокировщика RentrantLock
//            reentrantLock.isLocked() ресурс уже заблокирован boolean
//            reentrantLock.getQueueLength() узнать какая очередь за ресурсом
//            boolean isLocked = reentrantLock.tryLock(100, TimeUnit.MILLISECONDS); // поток ждет 100 милиссекунд,
//                                                                                  если ресурс не освободится,
//                                                                                  выполняем рабату не связанную с ресурсом.
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
