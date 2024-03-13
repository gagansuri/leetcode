package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class ThreeSumClosestToTheTarget_16 {
    public static void main(String[] args) {
        int[]nums = {-1, 2, 1, -4};
        int target = 1;
        threeSumClosest(nums,target);
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        /**
         3sum implementation
         take first number i
         then take a number from left which is i+1 and take another number from
         right
         if ( sum is = target , add to the set)

         **/
        int globalDiff = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0 ; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - sum);
                //System.out.println(" nums[i]: "+nums[i] + " nums[left]:"+nums[left] +" nums[right]: "+nums[right] +" diff: "+diff +" result: "+result);
                if(diff < globalDiff) {
                    globalDiff = diff;
                    result = sum;
                }



                if(sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println("result: "+result);
        return result;
    }

}
