package com.test.javanew.concurrency;

import java.util.concurrent.*;

public class CFProcessingResultsOfAsyncComputations {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //The most generic way to process the result of a computation is to feed it to a function.
        // The thenApply method does exactly that: accepts a Function instance, uses it to process
        // the result and returns a Future that holds a value returned by a function
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future = completableFuture
                .thenApply(s -> s + " World");

        System.out.println(future.get());


        //If you don't need to return a value down the Future chain, you can use an instance of the Consumer
        // functional interface.  Its single method takes a parameter and returns void.
        //
        //There's a method for this use case in the CompletableFuture — the thenAccept method receives
        // a Consumer and passes it the result of the computation. The final future.get() call returns
        // an instance of the Void type.

        CompletableFuture<String> completableFuture2
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future2 = completableFuture2
                .thenAccept(s -> System.out.println("Computation returned: " + s));

        future2.get();

        //At last, if you neither need the value of the computation nor want to return some value at
        // the end of the chain, then you can pass a Runnable lambda to the thenRun method.
        // In the following example, after the future.get() method is called,
        // we simply print a line in the console

        CompletableFuture<String> completableFuture3
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future3 = completableFuture3
                .thenRun(() -> System.out.println("Computation finished."));

        future3.get();
    }
}
