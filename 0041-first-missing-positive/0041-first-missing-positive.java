class Solution {
    public int firstMissingPositive(int[] nums) {
    int len = nums.length;
     // the numbers will be 1 to n + 1
     // if greater then n + 1 make it 1 or less than 0 make it 1

     // then make the indexes at negative
     // iterate again and whichever first index is not negative is the number
    int n = nums.length;
    boolean isOne = false;
    for(int i = 0 ; i < nums.length; i++) {
        if(nums[i] == 1) {
            isOne = true;
        }
        else if(nums[i] > n || nums[i] <= 0) {
            nums[i]  = 1;
        }
    }
    //
if(!isOne) return 1;

    for(int i = 0 ; i < nums.length; i++) {
        int index = Math.abs(nums[i]) - 1 ; // 0 based index
        if(nums[index] > 0) {
            nums[index] = -1 * nums[index];
        }
    }
    
    for(int i = 0 ; i < nums.length; i++) {
        if(nums[i] > 0) {
            return i+1;
        }
    }
    return n + 1;
    }
}