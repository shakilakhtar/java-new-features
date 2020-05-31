package com.test.javanew.datetime;

import java.time.*;

public class DateTimeTest {
    public static void main(String[] args) {
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
    }
}
