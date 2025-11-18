class Solution {
    public int maxSubArray(int[] nums) {
        int localMax = 0 , globalMax = Integer.MIN_VALUE;
        for(int n : nums) {
            localMax = Math.max(n,localMax+n);
            globalMax = Math.max(localMax, globalMax);
            //System.out.println("local Max : "+localMax +" globalMax :"+globalMax);
        }
        return globalMax;
    }
}