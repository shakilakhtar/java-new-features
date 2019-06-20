package com.test.javanew.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamConcatination {
    public static void main(String[] args) {

        //list 1
        List<String> alphabets = Arrays.asList("A","B","C");


        //list 2
        List<String> names = Arrays.asList("Sansa","Jon","Arya");

        Stream<String> concat = Stream.concat(alphabets.stream(),names.stream());

        concat.forEach(str-> System.out.println(str+ " "));

    }
}
