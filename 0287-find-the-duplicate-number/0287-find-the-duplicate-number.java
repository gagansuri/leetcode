class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0 ; i < nums.length; i++) {
            int a = nums[i];
            if(a < 0 ) a = a*-1;
            if(nums[a] < 0 ) return a;

            nums[a] = -1*nums[a];
        }        
        return -1;
    }
}