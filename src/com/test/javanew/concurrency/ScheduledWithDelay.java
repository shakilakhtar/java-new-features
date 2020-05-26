package com.test.javanew.concurrency;

import java.util.concurrent.*;

public class ScheduledWithDelay {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);

    }
}
