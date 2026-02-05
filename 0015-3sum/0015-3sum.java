class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //nlogn
        Set<List<Integer>> result = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                  List<Integer> list = new ArrayList<>();
                  list.add(nums[i]);
                  list.add(nums[left++]);
                  list.add(nums[right--]);
                  result.add(list);
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
                
            }
            
        }
        
        return new ArrayList<>(result);
    }
}