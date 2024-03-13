package com.leetcode;

public class MinimumSizeSubArraySum_209 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target,nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minSize = nums.length + 1, currentSum = 0 ;
        int left = 0;
        for(int right = 0 ; right < nums.length ; right++) {
            currentSum += nums[right];
            while(left < right && (currentSum - nums[left]) >= target) {
                currentSum -= nums[left];
                left++;
            }
            if(currentSum >= target) {
                minSize = Math.min(minSize, (right - left +1));

            }
        }
        return minSize == nums.length + 1 ? 0 : nums.length;
    }

}
