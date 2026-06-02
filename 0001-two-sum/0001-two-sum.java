class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0 ) return null;
        Map<Integer, Integer> lookup = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++) {
            if(lookup.containsKey(target - nums[i])) {
                //match found;
                int[] result = new int[2];
                result[0] = lookup.get(target - nums[i]);
                result[1] = i; 
                return result;
            } else {
                lookup.put(nums[i] ,  i );
            }
        }
    return null;
    }
}