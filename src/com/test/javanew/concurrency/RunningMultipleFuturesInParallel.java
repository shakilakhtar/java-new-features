package com.test.javanew.concurrency;

import java.util.concurrent.*;
import java.util.stream.*;

public class RunningMultipleFuturesInParallel {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(future1, future2, future3);


        combinedFuture.get();

        System.out.println(future1.isDone());
        System.out.println(future2.isDone());
        System.out.println(future3.isDone());

        //Notice that the return type of the CompletableFuture.allOf() is a CompletableFuture<Void>.
        // The limitation of this method is that it does not return the combined results of all Futures.
        // Instead you have to manually get results from Futures.
        // Fortunately, CompletableFuture.join() method and Java 8 Streams API makes it simple

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        System.out.println("Combined : " + combined);
    }
}
