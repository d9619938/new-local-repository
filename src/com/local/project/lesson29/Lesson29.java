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
                1000, TimeUnit.NANOSECONDS,
                new ArrayBlockingQueue<>(100));
        pool.execute(service01);
        pool.shutdown();

        // КЭШИРУЮЩИЙ ПУЛ ПОТОКОВ
        ExecutorService cachedService = Executors.newCachedThreadPool(); // кэширующий пул потоков.
        // Служит для быстровыполняющихся задач
        cachedService.execute(() -> {
            System.out.println("Cached pool Fast Task");
        });
        cachedService.shutdown(); //

        //
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        Future<String> taskResultContainer = singlePool.submit(new RequestTask()); //результат работы возвращается в
        // контейнер Future
        while (!taskResultContainer.isDone()) {
            //какие-то действия основного потока
        }

        String result = null;
        try {
//            result = taskResultContainer.get();
            result = taskResultContainer.get(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            System.out.println("у ожидающего потока был вызван метод interrupt");
        } catch (ExecutionException e) {
            System.out.println("во время выполнения задачи выброшено исключение");
        } catch (TimeoutException e) {
            System.out.println("main поток не смог дождаться завершения задачи");
        }
        System.out.println(result);

        // ПУЛ НА ОДИН ПОТОК
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
        // ThreadPoolExecutor | ForkJoinPool - основан на принципе разделения и объединения и КРАЖЕ РАБОБТЫ ДРУГИХ ПОТОКОВ
        // Executors - создающий класс,
        ExecutorService stealingPool01 = Executors.newWorkStealingPool(); // если без аргументов, то количество потоков
        // будет равно количеству свободных ядер
        stealingPool01.execute(() -> {
            System.out.println("Cached pool Fast Task");
        });
//    ExecutorService  stealingPool = Executors.newWorkStealingPool(3); // либо сами указываем количество потоков
        // t1 -> taskqueue
        // t2 -> taskqueue
        // t3 -> taskqueue
//    каждый поток работает со своей очередью, берут задачу с начала очереди.
//    Если задачи у потока выполнены, то он берет задачу из КОНЦА очереди другого потока.

        // и другие методы ExecutorService


//        ForkJoinPool forkJoinPool = new ForkJoinPool(); можно создать двумя способами.
        FileFinder fileFinder = new FileFinder(
                new File("file.txt"),
                        new File("C:\\Users\\d9619\\IdeaProjects\\new-local-repository"));

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        // есть asyncMode - асинхронный режим
        forkJoinPool.invoke(fileFinder);
        try {
            File file = fileFinder.get();  // вернет первый попавшийся файл из результата поиска FileFinder
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }





        // Пул работающий по расписанию // работает с очередью, привязанной ко времени DelaydQueue
        ScheduledExecutorService scheduledExecutorService01 = Executors.newScheduledThreadPool(2);

        // три основных метода

        scheduledExecutorService01.scheduleAtFixedRate(()->{  //метод принимает задачу, которую нужно выполнять
            // Runnable
            System.out.println("Задача, которая" +
                    "должна выполняться каждые 3 минуты");
        }, 0, 3, TimeUnit.MINUTES); // задача должна выполняться каждые 3 минуты,
        // но если сама задача выполняется дольше, то следующая задача встанет в очередь и если потоков не будет хватать
        // то все рано или поздно закончится нехваткой ресурсов

        scheduledExecutorService01.scheduleWithFixedDelay(()->{  //метод принимает задачу, которую нужно выполнять
            // Runnable
            System.out.println("Задача, которая" +
                    "должна выполняться каждые 3 минуты" +
                    "после окончания предыдущей задачи");
        }, 0, 3, TimeUnit.MINUTES);

        scheduledExecutorService01.schedule(()->{  //метод принимает задачу, которую нужно выполнять 1
            // раз через пять минут после запуска
            // Runnable
            System.out.println("Задача, которая" +
                    "должна выполнится через пять минут после запуска");
        }, 5, TimeUnit.MINUTES);

        scheduledExecutorService01.shutdown(); // остановка выполнения задач...текущие завершатся, новые брать не будет
    }
}

