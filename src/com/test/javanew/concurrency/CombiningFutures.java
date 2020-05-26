package com.test.javanew.concurrency;

import java.util.concurrent.*;

public class CombiningFutures {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //combine CompletableFuture instances in a chain of computation steps
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
        System.out.println(completableFuture.get());

        //f you want to execute two independent Futures and do something with their results,
        // use the thenCombine method that accepts a Future and a Function with two arguments
        // to process both results

        CompletableFuture<String> completableFuture2
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(
                        () -> " World"), (s1, s2) -> s1 + s2);

        System.out.println(completableFuture2.get());

        //A simpler case is when you want to do something with two Futures‘ results,
        // but don't need to pass any resulting value down a Future chain.
        // The thenAcceptBoth method is there to help

        CompletableFuture future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
                        (s1, s2) -> System.out.println(s1 + s2));
    }
}
