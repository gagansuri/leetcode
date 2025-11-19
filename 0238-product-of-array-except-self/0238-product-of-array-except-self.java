class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        if(nums == null || nums.length ==0) return null;
        int temp = 1;
        for(int i = 0 ; i <nums.length; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for(int i = nums.length - 1; i >=0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }

    return result;    
    }

}