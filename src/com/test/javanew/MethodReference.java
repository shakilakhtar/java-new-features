package com.test.javanew;

@java.lang.FunctionalInterface
interface MyInterface{
    void display();
}

public class MethodReference {
    public static void main(String[] args) {
        MethodReference mr = new MethodReference();

        //method reference using the object of the class
        MyInterface i =  mr::myMethod;
        //calling the method of functional interface
        i.display();
    }

    public void myMethod(){
        System.out.println("Instance Method");
    }
}
