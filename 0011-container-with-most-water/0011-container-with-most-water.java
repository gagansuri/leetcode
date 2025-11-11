class Solution {
    public int maxArea(int[] height) {
    int maxWater = 0 ,  left = 0 , right = height.length - 1;
    while(left < right) {
        int water = Math.min(height[left], height[right]) * (right - left);
        maxWater = Math.max(water, maxWater);

        if(height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    return maxWater;
    }
}