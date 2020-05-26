package com.test.javanew.concurrency;

public class ThreadExamples {

    public static void main(String[] args) {

        createThread();
    }

    public static void createThread() {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello "+threadName);
        };

        task.run();
        Thread t = new Thread(task);
        t.start();
        System.out.println("Done!");

    }
}
