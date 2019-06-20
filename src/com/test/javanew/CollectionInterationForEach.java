package com.test.javanew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionInterationForEach {

    public static void main(String[] args) {

        List<String> fruits=new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Guava");
        fruits.add("Grapes");

        //iterating using foreach and javanew

        fruits.forEach((fruit)-> System.out.println(fruit));

        //For each for map

        System.out.println("=============================");
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Apple", 50);
        prices.put("Orange", 20);
        prices.put("Banana", 10);
        prices.put("Grapes", 40);
        prices.put("Papaya", 50);

        //for each javanew interation

        prices.forEach((k,v)-> System.out.println("Fruit :" +k+ " Price: " +v));
    }
}
