package com.leetcode.top75.tree;

import java.util.*;
public class Kids_WithGreatestCandies_1431 {
    public static void main(String[] args) {
        int[]candies={2,3,5,1,3};
        int extra = 3;
        System.out.println(kidsWithCandies(candies,extra));
    }
        public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = 0 ;
            List<Boolean> result = new ArrayList<>();
            for(int n : candies) {
                max = Math.max(max, n);
            }

            for(int i = 0; i < candies.length ; i++) {
                if((candies[i] + extraCandies) >= max) {
                    result.add(true);
                }  else {
                    result.add(false);
                }
            }
            return result;
        }
    }

