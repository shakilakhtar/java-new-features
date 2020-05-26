package com.test.javanew.concurrency;

import java.util.concurrent.*;

public class CompletablFutureWithEncapsulatedComputationLogic {
    public static void main(String[] args) {

        CompletableFuture<String> future
                = CompletableFuture.supplyAsync(() -> "Hello");
    }
}
