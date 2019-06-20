package com.test.javanew.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Smaeer");
        names.add("Negan");
        names.add("Jenifer");
        names.add("Steve");

        long count = names.stream().filter(str->str.length()<6).count();
        System.out.println("No of names less than 6 characters : " +count);
    }
}
