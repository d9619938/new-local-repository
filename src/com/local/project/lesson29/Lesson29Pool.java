package com.local.project.lesson29;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Lesson29Pool extends ThreadPoolExecutor {

    public Lesson29Pool(
            int corePoolSize,     // �����������, �� �� ����������� ������ ����
            int maximumPoolSize,  // ������������ ������ ����, ���� ������ ���������� ��-�� �������� ������� � ��������� �����
            long keepAliveTime,   // ����� ����������� ������ ��� ������
            TimeUnit unit,        // ������� ��������� keepAliveTime
            BlockingQueue<Runnable> workQueue) {  //������� ��� �����

        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
     if (t != null)  System.out.println(t.getMessage());
    }

}
