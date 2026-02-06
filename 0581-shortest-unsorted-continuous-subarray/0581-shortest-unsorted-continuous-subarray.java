class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] numsC = nums.clone();
        Arrays.sort(numsC);
        int left = 0, right = nums.length - 1;

        while(left < right) {
            if(nums[left] != numsC[left] && nums[right] != numsC[right]) {
                return right - left + 1;
            } 

            left++; right--;

        } 
    return 0;
        
    }
}