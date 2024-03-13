package com.general;

import java.util.*;

public class FruitCrush_Amazon {

    public static void main(String[] args) {
        // In this game, you are allowed to choose two dissimilar fruits and crush them. Eath type of fruit is represened as an integer in an array.

        int[] fruits = {3,3,1,1,2};
        fruits = new int[]{1234, 1234, 1234, 1234, 1234};
        //System.out.println(fruitCrush(fruits));

        List<String> list = new ArrayList<>();
        list.add("let1 art can");
        list.add("let2 own kit dig");
        list.add("let3 art zero");
        Collections.sort(list , (a,b)-> a.substring(a.indexOf(' '),a.length()).equals(b.substring(b.indexOf(' '),b.length()))?
                a.substring(0,a.indexOf(' ')).compareTo(b.substring(0,b.indexOf(' '))): a.substring(a.indexOf(' '),a.length()).compareTo(b.substring(b.indexOf(' '),b.length())));

        list.stream().forEach(System.out::println);

    }

    static int fruitCrush(int[] fruits) {
        Map<Integer,Integer> fruitsCountMap = new HashMap<>();

        for(int n : fruits) {
            fruitsCountMap.put(n, fruitsCountMap.getOrDefault(n,0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> fruitsCountMap.get(b)- fruitsCountMap.get(a));

        for(int n : fruitsCountMap.keySet()) {
            heap.add(n);
        }

        while(heap.size() > 1) {
            // pop top 2 from heap
            // find the differenc of count
            // delete the lower count from map
            // push the new count to map
            // push the remaining to the heap
            int highestCount1Fruit = heap.poll();
            int highestCount2Fruit = heap.poll();

            int newCount = fruitsCountMap.get(highestCount1Fruit) - fruitsCountMap.get(highestCount2Fruit);
            if(newCount == 0) {
                fruitsCountMap.remove(highestCount1Fruit);
                fruitsCountMap.remove(highestCount2Fruit);
            } else {
                fruitsCountMap.remove(highestCount2Fruit);
                fruitsCountMap.put(highestCount1Fruit,newCount);
                heap.add(highestCount1Fruit);
            }
        }
        return heap.isEmpty() ? 0 : fruitsCountMap.get(heap.poll());
   }
}
