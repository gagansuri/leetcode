class Solution {
    public int findDuplicate(int[] nums) {
        int nums1[] = new int[nums.length+1];
        for(int i = 0 ; i < nums.length; i++) {
            if(nums1[nums[i]] == nums[i]) return nums[i];

            nums1[nums[i]] = nums[i];
        }
        return -1; 
    }

    public int findDuplicate1(int[] nums) {
        for(int i = 0 ; i < nums.length; i++) {
            int a = nums[i];
            if(a < 0 ) a = a*-1;
            if(nums[a] < 0 ) return a;

            nums[a] = -1*nums[a];
        }        
        return -1;
    }
}