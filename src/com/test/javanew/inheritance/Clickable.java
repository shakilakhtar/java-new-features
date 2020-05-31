package com.test.javanew.inheritance;

public interface Clickable {
    default void click() {
        System.out.println("click");
    }

    default void print() {
        System.out.println("Clickable");
    }
}
