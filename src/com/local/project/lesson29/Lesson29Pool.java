package com.local.project.lesson29;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Lesson29Pool extends ThreadPoolExecutor {

    public Lesson29Pool(
            int corePoolSize,     // изначальный, он же минимальный размер пула
            int maximumPoolSize,  // максимальный размер пула, если потоки необходимы из-за дефицита потоков и профицита задач
            long keepAliveTime,   // время бездействия потока без задачи
            TimeUnit unit,        // единица измерения keepAliveTime
            BlockingQueue<Runnable> workQueue) {  //очередь для задач

        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
     if (t != null)  System.out.println(t.getMessage());
    }

}
