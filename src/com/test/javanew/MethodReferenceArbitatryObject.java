package com.test.javanew;

import java.util.Arrays;

public class MethodReferenceArbitatryObject {

    public static void main(String[] args) {
        String[] stringArray = { "Steve", "Rick", "Sameer", "Negan", "Lucy", "Sansa", "Jon"};

        Arrays.sort(stringArray,String::compareToIgnoreCase);
        for(String s:stringArray){
            System.out.println(s);
        };
    }
}
