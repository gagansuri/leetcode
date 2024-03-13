package com.javacode;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsCheck {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>() ;
 //       Arrays.asList([“Apple”, “banana”, “cat”, “dog”]);
        names.add("Apple");
        names.add("banana");
        names.add("cat");
        names.add("dog");
        Map<Integer, List<String>> result= names.stream().collect(Collectors.groupingBy(s-> s.length(), Collectors.toList()));
        System.out.println(result);

    }
}
