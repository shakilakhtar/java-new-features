package com.test.javanew;

import java.util.function.BiFunction;

class Multiplication{
    public static int multiply(int a, int b){
        return a*b;
    }
}

public class MethodReferenceStatic {
    public static void main(String[] args) {

        BiFunction<Integer,Integer,Integer> product = Multiplication::multiply;
        int pr =product.apply(10,10);
        System.out.println("Multiplication of two number is : "+pr);
    }
}
