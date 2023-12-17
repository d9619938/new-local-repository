package com.local.project.lesson29;
import java.io.File;
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
                1000, TimeUnit.NANOSECONDS,
                new ArrayBlockingQueue<>(100));
        pool.execute(service01);
        pool.shutdown();

        // ���������� ��� �������
        ExecutorService cachedService = Executors.newCachedThreadPool(); // ���������� ��� �������.
        // ������ ��� ������������������� �����
        cachedService.execute(() -> {
            System.out.println("Cached pool Fast Task");
        });
        cachedService.shutdown(); //

        //
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        Future<String> taskResultContainer = singlePool.submit(new RequestTask()); //��������� ������ ������������ �
        // ��������� Future
        while (!taskResultContainer.isDone()) {
            //�����-�� �������� ��������� ������
        }

        String result = null;
        try {
//            result = taskResultContainer.get();
            result = taskResultContainer.get(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            System.out.println("� ���������� ������ ��� ������ ����� interrupt");
        } catch (ExecutionException e) {
            System.out.println("�� ����� ���������� ������ ��������� ����������");
        } catch (TimeoutException e) {
            System.out.println("main ����� �� ���� ��������� ���������� ������");
        }
        System.out.println(result);

        // ��� �� ���� �����
        List<Future<String>> results = null;
        try {
            results = singlePool.invokeAll(Arrays.asList(new RequestTask(), new RequestTask()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (Future<String> future : results) {
            try {
                String res = future.get(11_000, TimeUnit.MILLISECONDS);
                System.out.println(res);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
        singlePool.shutdown();


        // Executor
        // ExecutorService
        // ThreadPoolExecutor | ForkJoinPool - ������� �� �������� ���������� � ����������� � ����� ������� ������ �������
        // Executors - ��������� �����,
        ExecutorService stealingPool01 = Executors.newWorkStealingPool(); // ���� ��� ����������, �� ���������� �������
        // ����� ����� ���������� ��������� ����
        stealingPool01.execute(() -> {
            System.out.println("Cached pool Fast Task");
        });
//    ExecutorService  stealingPool = Executors.newWorkStealingPool(3); // ���� ���� ��������� ���������� �������
        // t1 -> taskqueue
        // t2 -> taskqueue
        // t3 -> taskqueue
//    ������ ����� �������� �� ����� ��������, ����� ������ � ������ �������.
//    ���� ������ � ������ ���������, �� �� ����� ������ �� ����� ������� ������� ������.

        // � ������ ������ ExecutorService


//        ForkJoinPool forkJoinPool = new ForkJoinPool(); ����� ������� ����� ���������.
        FileFinder fileFinder = new FileFinder(
                new File("file.txt"),
                        new File("C:\\Users\\d9619\\IdeaProjects\\new-local-repository"));

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        // ���� asyncMode - ����������� �����
        forkJoinPool.invoke(fileFinder);
        try {
            File file = fileFinder.get();  // ������ ������ ���������� ���� �� ���������� ������ FileFinder
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }





        // ��� ���������� �� ���������� // �������� � ��������, ����������� �� ������� DelaydQueue
        ScheduledExecutorService scheduledExecutorService01 = Executors.newScheduledThreadPool(2);

        // ��� �������� ������

        scheduledExecutorService01.scheduleAtFixedRate(()->{  //����� ��������� ������, ������� ����� ���������
            // Runnable
            System.out.println("������, �������" +
                    "������ ����������� ������ 3 ������");
        }, 0, 3, TimeUnit.MINUTES); // ������ ������ ����������� ������ 3 ������,
        // �� ���� ���� ������ ����������� ������, �� ��������� ������ ������� � ������� � ���� ������� �� ����� �������
        // �� ��� ���� ��� ������ ���������� ��������� ��������

        scheduledExecutorService01.scheduleWithFixedDelay(()->{  //����� ��������� ������, ������� ����� ���������
            // Runnable
            System.out.println("������, �������" +
                    "������ ����������� ������ 3 ������" +
                    "����� ��������� ���������� ������");
        }, 0, 3, TimeUnit.MINUTES);

        scheduledExecutorService01.schedule(()->{  //����� ��������� ������, ������� ����� ��������� 1
            // ��� ����� ���� ����� ����� �������
            // Runnable
            System.out.println("������, �������" +
                    "������ ���������� ����� ���� ����� ����� �������");
        }, 5, TimeUnit.MINUTES);

        scheduledExecutorService01.shutdown(); // ��������� ���������� �����...������� ����������, ����� ����� �� �����
    }
}

