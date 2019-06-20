package com.test.javanew;

@java.lang.FunctionalInterface
interface MyInterfaceCtor{
    Hello display(String say);
}
class Hello{
    public Hello(String say){
        System.out.print(say);
    }
}

public class MethodReferenceCtor {
    public static void main(String[] args) {
        MyInterfaceCtor mic =Hello::new;
        mic.display("Hello World!");
    }
}