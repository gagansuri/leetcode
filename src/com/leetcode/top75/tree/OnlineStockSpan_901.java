package com.leetcode.top75.tree;

import java.util.*;

public class OnlineStockSpan_901 {
    private List<Integer> prices = new ArrayList<>();
    private int currentIndex = -1;
    public OnlineStockSpan_901() {

    }

    public static void main(String[] args) {
    OnlineStockSpan_901 onl = new OnlineStockSpan_901();
    //[[],[29],[91],[62],[76],[51]]
    // [null,1,2,1,2,1]
    System.out.println(onl.next(29));
    System.out.println(onl.next(91));
    System.out.println(onl.next(62));
    System.out.println(onl.next(76));
    System.out.println(onl.next(51));
    //Map<String, Integer> countMap = new TreeMap<>((a, b) -> b.getValue() - a.getValue());
        Map<String, Integer> countMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }
    public int next(int price) {
        prices.add(++currentIndex,price);
        int span = 0;
        for(int i = 0;i < currentIndex; i++) {
            if(prices.get(currentIndex) > prices.get(i)) {
                span++;
            } else {
                break;
            }
        }
        return span+1;
    }
}


