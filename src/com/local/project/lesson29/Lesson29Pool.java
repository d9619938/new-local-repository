package com.local.project.lesson29;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class Lesson29Pool extends ThreadPoolExecutor {

    public Lesson29Pool(int corePoolSize, // изначальный он же минимальный размер пула
                        int maximumPoolSize, // максимальный размер пула
                        long keepAliveTime,  // время бездействия потока
                        java.util.concurrent.TimeUnit unit, // ед. измерения
                        BlockingQueue<Runnable> workQueue) { // очередь для задач
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
    @Override
    protected void afterExecute(Runnable r, Throwable e) {
        System.out.println(e);
    }

}
