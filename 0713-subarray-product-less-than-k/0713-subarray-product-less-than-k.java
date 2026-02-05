class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0 , right = 0,  count = 0 ;
        int product = 1;
        if(k<=1) return 0; 
        while(right < nums.length) {
            // check the current number
            product = product * nums[right];
            while( product >= k) {
                product = product/nums[left++];
            }
            count += 1 +(right - left);

            right++;
        }
        return count;
    }
}