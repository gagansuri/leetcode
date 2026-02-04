class Solution {
    public int removeDuplicates(int[] nums) {
       int count = 0, index = 1;
       for(int i = 1 ; i < nums.length ; i++) {
        if(nums[i] == nums[i-1]) {
            count++;
            if(count > 1) {
                continue;
            } else {
                nums[index++] = nums[i];
            }
        } else {
            count = 0;
            nums[index++] = nums[i];
        }

       } 
    return index;
    }
}