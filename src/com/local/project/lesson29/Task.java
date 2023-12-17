package com.local.project.lesson29;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Task implements Delayed {   // DelayedQueue для задач, которые нужно выполнять по времени
    
    private Runnable action;
    private LocalDateTime time; 

    public Task(Runnable action, LocalDateTime time) {
        this.action = action;
        this.time = time;
    }

    public Runnable getAction() {
        return action;
    }

    @Override
    public long getDelay(TimeUnit unit) {  // для метода take(), когда из очереди будем доставать задачу,
        // до сначала будем проверять методом getDely, если вернется 0 - то можно извлечь или - если еще нельзя извлечь элемент из очереди.
        return unit.convert(
                Duration.between(LocalDateTime.now(), time).getSeconds(),
                TimeUnit.SECONDS);
    }

    
    @Override // put
    public int compareTo(Delayed o) {  //используется для добавления элемента в очередь, чтобы отсортировать по дате-времени выполнения
        LocalDateTime other = ((Task) o).time;
        return this.time.compareTo(other);
    }
}