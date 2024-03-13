package com.leetcode.top75.tree;

import java.util.*;

public class TopKFrequentWords_692 {
    public static void main(String[] args) {
        String[] words =  {"i","love","leetcode","i","love","coding"};
        String[] words2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        //topKFrequent(words2,4);
        //new ArrayList<String>().subList(0,5);
        checKMinHeapImp();

        topKFrequentSubList(words,2);
        topKFrequentSubList(words2,4);
    }


    public static void checKMinHeapImp() {
        String[] words2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int[] nums = {89,33,1,3,4,67,8,37,58};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->b.compareTo(a));
        for(int n : nums) {
            minHeap.add(n);
            if(minHeap.size() > 4) {
                System.out.println("Removed :"+minHeap.poll());
            }
        }

        System.out.println("smallest four elements : "+minHeap);
        for(int i = 0 ; i < 4; i++) {
            System.out.println(minHeap.poll());
        }
    }
    public static List<String> topKFrequent(String[] words, int k) {
        //PriorityQueue<String,Integer> heap = new LinkedList<>();
        Map<String, Integer> countMap = new TreeMap<>();
        for(String word : words) {
            countMap.put(word, countMap.getOrDefault(word,0)+1);
        }
        System.out.println(countMap);
        PriorityQueue<String> minHeap = new PriorityQueue<String>(
                (s1,s2) -> countMap.get(s2).equals(countMap.get(s1))? s1.compareTo(s2) : countMap.get(s2).compareTo(countMap.get(s1)));


        for(String key : countMap.keySet()) {
            minHeap.add(key);
        }
        System.out.println("min:"+minHeap);
        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < k; i++) {
            result.add(minHeap.remove());
        }
        System.out.println("final " +result);
        return result;
    }

    public static List<String> topKFrequentSubList(String[] words, int k) {
        //PriorityQueue<String,Integer> heap = new LinkedList<>();
        Map<String, Integer> countMap = new TreeMap<>();
        for(String word : words) {
            countMap.put(word, countMap.getOrDefault(word,0)+1);
        }
        System.out.println(countMap);
        PriorityQueue<String> maxHeap = new PriorityQueue<>((s1,s2) -> countMap.get(s1).equals(countMap.get(s2)) ? s1.compareTo(s2) : countMap.get(s2).compareTo(countMap.get(s1)));

        for(String key : countMap.keySet()) {
            maxHeap.add(key);
        }
        System.out.println("min:"+maxHeap);
        List<String> result = new ArrayList<>(maxHeap);

        System.out.println("final " +result.subList(0,k));
        return result;
    }
}
