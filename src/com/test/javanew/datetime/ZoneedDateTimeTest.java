package com.test.javanew.datetime;

import java.time.*;

public class ZoneedDateTimeTest {
    public static void main(String[] args) {
        final Clock clock = Clock.systemUTC();
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(clock);
        final ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

        System.out.println(zonedDateTime);
        System.out.println(zonedDateTimeFromClock);
        System.out.println(zonedDateTimeFromZone);
    }
}
