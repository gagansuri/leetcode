package com.leetcode.top75.tree;

public class SingleNumber_136 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
    }
        public static int singleNumber(int[] nums) {
            int res = nums[0] ;
            for(int i = 1 ; i < nums.length  ; i++) {
                res ^= nums[i] ;
            }
            return res;
        }
}
