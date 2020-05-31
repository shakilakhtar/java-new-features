package com.test.javanew.concurrency;

import java.util.concurrent.locks.*;

public class StampedLocks {
    public static void main(String[] args) {
        final StampedLock lock = new StampedLock();

        long stamp = lock.tryOptimisticRead(); // non blocking path - super fast
        work(); // we're hoping no writing will go on in the meanwhile
        if (lock.validate(stamp)) {
            //success! no contention with a writer thread
        } else {
            //another thread must have acquired a write lock in the meanwhile, changing the stamp.
            //bummer - let's downgrade to a heavier read lock

            stamp = lock.readLock(); //this is a traditional blocking read lock
            try {
                //no writing happening now
                work();

            } finally {
                lock.unlock(stamp); // release using the correlating stamp
            }
        }
    }

    public static void work() {
        System.out.println("Doing work!");
    }
}
