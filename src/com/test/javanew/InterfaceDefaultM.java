package com.test.javanew;

interface MyDeafaultInterface{

    //deafult interface method
    default void doIt(){
        System.out.println("Executing interface default method...");
    }

    //static interface method
    static void doInStatic(){
        System.out.println("Interface's static method...");

    }
}

public class InterfaceDefaultM implements MyDeafaultInterface{
    public static void main(String[] args) {

        InterfaceDefaultM im = new InterfaceDefaultM();
        im.doIt();

    }
}
