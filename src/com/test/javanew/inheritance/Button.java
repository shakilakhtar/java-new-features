package com.test.javanew.inheritance;

public class Button implements Clickable, Accessible {
    public void print() {
        Clickable.super.print();
        Accessible.super.print();
    }

    public static void main(String[] args) {
        Button button = new Button();
        button.click();
        button.access();
        button.print();
    }
}
