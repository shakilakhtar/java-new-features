package com.test.javanew;

import java.util.StringJoiner;

public class StringJoinerClass {
    public static void main(String[] args) {

        StringJoiner mystring = new StringJoiner("-");

        // Joining multiple strings by using add() method
        mystring.add("Logan");
        mystring.add("Magneto");
        mystring.add("Rogue");
        mystring.add("Storm");

        // Displaying the output String
        System.out.println(mystring);
    }
}
