class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> lookup = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            if(lookup.containsKey(target-nums[i])) {
                return new int[]{lookup.get(target-nums[i]),i};
            } else {
                lookup.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No valid indices found");
    }
}