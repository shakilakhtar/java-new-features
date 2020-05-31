package com.test.javanew;

import java.util.*;

public class OptionalUse {
    public static void main(String[] args) {
        Optional<String> fullName = Optional.of("Tom");
        fullName = Optional.ofNullable(null);
        System.out.println("Full name is set? =" + fullName.isPresent());
        System.out.println("Full name  =" + fullName.orElseGet(() -> "[none]"));
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));

    }
}
