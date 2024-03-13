package com.leetcode.top75.tree;

import java.util.*;
public class MaxNumberOfKSumpairs_1679 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] nums1 = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};

        int k = 3;
        System.out.println(maxOperations(nums1,k));
    }
    public static int maxOperations(int[] nums, int k) {
            Map<Integer, Integer> lookupMap = new HashMap<>();
            int count = 0 ;
            for(int n : nums) {
                if(lookupMap.containsKey(k-n)) {
                    if(lookupMap.get(k-n) == 1) {
                        lookupMap.remove(k-n);
                    } else {
                        lookupMap.put(k-n, lookupMap.get(k-n)-1);
                    }
                    count++;
                } else {
                    lookupMap.put(n,lookupMap.getOrDefault(n,0)+1);
                }
            }
            return count;
        }
}

