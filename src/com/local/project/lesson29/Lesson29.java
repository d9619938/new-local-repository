package com.local.project.lesson29;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Lesson29 {
    public static void main(String[] args) {
        List<String> tokens = new ArrayList<>(
                Arrays.asList("123", "456", "789"));

        ReentrantLock lock = new ReentrantLock(/*true*/); // true - ���� ��������������, ������ ������� ������ � �������
                                                            // � ������� �������, ����������� � �������
        Semaphore semaphore = new Semaphore(tokens.size(), true);  // ��� ���������� ����� ��������������,
                                                            // ����� �������� ����������, ������� ����������� ����� ������

        // ������ ����� ������ ��� �����������
        // ����� ����� ������������ ������ ���� ���
        // �������������� ����� ����� �������� �����

        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();

        ArrayBlockingQueue<String> tokensQueue = new ArrayBlockingQueue<>(3, true, Arrays.asList("123", "456", "789"));
        // ����� �������� ���� ��������������, � �������� �� �����-�� ���������.
        // ������ ��������� �� ������ ��������� ������ ������� (capacity)

    QueueClientService service01 = new QueueClientService(tokensQueue);

    new Thread(service01).start();
    new Thread(service01).start();
    new Thread(service01).start();
    new Thread(service01).start();


    //���� �������
        ExecutorService service = Executors.newFixedThreadPool(3); // ��������� ��� ������� �� 3 ������.. ������������� ������
        // [t1, t2, t3]
        // BlockingQueue[r4] - ������� �����
        // t1 -> r1 ... ���� ����� �����������, �� ����� ����� ������ r4
        // t2 -> r2
        // t3 -> r3
        // t1 -> r4

        service.execute(service01); // �������� ������ ���� �������, � ������ ��������� � �������
        service.shutdown(); // ����� ������ ����� ������ ��� ������ �� ���� ������� ���� � ������� ���������� � ������ ������ ����� ���������� � ����.
//        List<Runnable> runnables = service.shutdownNow(); // ���������� ��������� ����� ������, �� ��, ��� � ������� ������ � ����.


        Lesson29Pool pool = new Lesson29Pool(3,
                7,
                1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(100));
        pool.execute(service01);
        pool.shutdown();


    }
}

