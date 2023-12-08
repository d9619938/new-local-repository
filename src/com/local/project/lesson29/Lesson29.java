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

        ReentrantLock lock = new ReentrantLock(/*true*/); // true - флаг справедливости, потоки получат доступ к ресурсу
                                                            // в порядке очереди, применяется с циклами
        Semaphore semaphore = new Semaphore(tokens.size(), true);  // при включенном флаге справедливости,
                                                            // когда появится разрешение, семафор предоставит токен потоку

        // токены нужны только для подключения
        // токен можно использовать только один раз
        // использованный токен нужно заменить новым

        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();
        new SynchronizedClientService(tokens, lock, semaphore).start();

        ArrayBlockingQueue<String> tokensQueue = new ArrayBlockingQueue<>(3, true, Arrays.asList("123", "456", "789"));
        // можно передать флаг справедливости, и основать на какой-то коллекции.
        // Размер коллекции не должен превышать размер очереди (capacity)

    QueueClientService service01 = new QueueClientService(tokensQueue);

    new Thread(service01).start();
    new Thread(service01).start();
    new Thread(service01).start();
    new Thread(service01).start();


    //пулы потоков
        ExecutorService service = Executors.newFixedThreadPool(3); // создается пул потоков на 3 потока.. фиксированный размер
        // [t1, t2, t3]
        // BlockingQueue[r4] - очередь задач
        // t1 -> r1 ... если поток освободился, то может взять задачу r4
        // t2 -> r2
        // t3 -> r3
        // t1 -> r4

        service.execute(service01); // передать задачу пулу потоков, а точнее поместить в очередь
        service.shutdown(); // после вызова этого метода все задачи из пула которые есть в очереди выполнятся и больше нельзя будет обратиться к пулу.
//        List<Runnable> runnables = service.shutdownNow(); // перестанет принимать новые задачи, но те, что в очереди вернет в лист.


        Lesson29Pool pool = new Lesson29Pool(3,
                7,
                1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(100));
        pool.execute(service01);
        pool.shutdown();


    }
}

