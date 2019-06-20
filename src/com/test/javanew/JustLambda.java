package com.test.javanew;

public class JustLambda {

    public static void main(String arg[]) {
       // Greeting greeting = (String s) -> "Hello! " + s;

        //System.out.println(greeting.greet("Shakil"));

        //javanew 2

        Greeting g= (int a, int b)->{
            if(a>10) return 10;
            else return a+b;
        };

        System.out.println(g.add(11,10));
    }
}

interface Greeting{
    //String greet(String s);

    int add(int a, int b);
}