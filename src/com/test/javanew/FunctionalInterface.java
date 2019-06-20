package com.test.javanew;

public class FunctionalInterface {

    public static void main(String[] args) {

        MyFuctionalInterface f = ()->{
            System.out.println("Hello Functional Interface");
        };

        f.greet();
    }
}


@java.lang.FunctionalInterface
interface MyFuctionalInterface{
    void greet();
}