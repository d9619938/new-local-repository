package com.local.project.lesson29;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedClientService extends Thread {
        private final List<String> tokens;
        private ReentrantLock reentrantLock;   // ������ synchronized (������ synchronized ����� ��� ������)
        private Semaphore semaphore;   // Semaphore - ���������� �� ������ � ������ �������

        public SynchronizedClientService(List<String> tokens, ReentrantLock reentrantLock,
                                         Semaphore semaphore) {
            this.tokens = tokens;
            this.reentrantLock = reentrantLock;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            String token;   // ����������, � ������� ����������� ����� �� ������

//            ������� ������������ RentrantLock
//            reentrantLock.isLocked() ������ ��� ������������ boolean
//            reentrantLock.getQueueLength() ������ ����� ������� �� ��������
//            boolean isLocked = reentrantLock.tryLock(100, TimeUnit.MILLISECONDS); // ����� ���� 100 �����������,
//                                                                                  ���� ������ �� �����������,
//                                                                                  ��������� ������ �� ��������� � ��������.
//            isLocked - true, ������� �������� ����������
//            isLocked - false, ������ �� ��� ���������� �� 100 MILLISECONDS

            try {
                semaphore.acquire(/*2*/); // ����� ����������� ���������� � ��������,
                                            // � ������� ��������� ���������� ����������
                                            // �� ���� ������� ����������� ���������� ������� ���������
                                            // ����� ��������� ������� semaphore


                reentrantLock.lock(); // ��� ���������� ���������� �������
//                token = tokens.removeLast();
                token = tokens.remove(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                reentrantLock.unlock(); // � ����� finally ��������������
            }

            String newToken = makeRequest(token);
            synchronized (tokens) {
                tokens.add(newToken);
            }
            semaphore.release();            // ����� ����������� ������� semaphore, ������� �����, ������� ����� ������!

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
