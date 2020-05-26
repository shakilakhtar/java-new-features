package com.test.javanew.concurrency;

import java.util.concurrent.*;

public class CompletableFutureHandlingErrors {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<String> completableFuture = new CompletableFuture<>();


        completableFuture.completeExceptionally(
                new RuntimeException("Calculation failed!"));


        completableFuture.get(); // ExecutionException

    }
}
