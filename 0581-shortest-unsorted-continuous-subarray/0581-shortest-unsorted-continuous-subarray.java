class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] numsC = nums.clone();
        Arrays.sort(numsC);
        int left = 0, right = nums.length - 1;

        while(left < right) {
            if(nums[left] == numsC[left] ) {
                left++;
            } else if(nums[right] == numsC[right]) {
                right--;
            } else {
                    return right - left + 1;
            }

            
        } 
    return 0;
        
    }
}