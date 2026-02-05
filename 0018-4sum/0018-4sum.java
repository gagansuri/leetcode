class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0 ; i < nums.length - 3; i++) {
            for(int j = i + 1 ; j < nums.length - 2 ; j++) {
                int left = j + 1, right = nums.length - 1;
                    while(left < right) {
                        long sum = nums[i];
                        sum += nums[j];
                        sum += nums[left];
                        sum += nums[right];
                        if(sum == target) {
                            res.add(List.of(nums[i], nums[j], nums[left++] , nums[right--]));    
                        } else if(sum > target) {
                            right--;
                        } else {
                            left++;
                        }
                    }
            }
        }
        return new ArrayList<>(res);
    }
}