package com.test.javanew.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public interface ExecutorInvokeAnyDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3));

        String result = executor.invokeAny(callables);
        System.out.println(result);
    }

    public static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }
}
