class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0 , right = 0;
        Set<Character> lookup = new HashSet<>();
        int max = 0 ;
        while(right < s.length()) {
            if(!lookup.contains(s.charAt(right))) {
                lookup.add(s.charAt(right));
                right++;
                max = Math.max(max, (right-left)); 
            } else {
                lookup.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}