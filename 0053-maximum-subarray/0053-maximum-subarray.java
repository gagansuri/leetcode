class Solution {
    public int maxSubArray(int[] nums) {
       int localMax = 0, globalMax = Integer.MIN_VALUE;
       int sum = 0 ;
       for(int i : nums) {
        localMax = Math.max(i, localMax + i);
        globalMax = Math.max(localMax, globalMax);
       }
       return globalMax;
    }
}