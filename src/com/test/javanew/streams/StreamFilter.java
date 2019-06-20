package com.test.javanew.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFilter {
    public static void main(String[] args) {


        List<String> names = Arrays.asList("Melisandre","Sansa","Jon","Daenerys","Joffery");

        //Creating the stream of all names
        Stream<String> allNames = names.stream();

        Stream<String> longNames = allNames.filter(str->str.length()>6);

        longNames.forEach(str-> System.out.println(str+ " "));
    }
}
