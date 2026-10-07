class Solution {
    public int lengthOfLongestSubstring(String s) {
    Set<Character> lookup = new HashSet<>();
    int left= 0 , right = 0 , max = 0 ;
    while(left <= right && right < s.length()) {
        char c  = s.charAt(right);
        if(!lookup.contains(c)) {
            lookup.add(c);
            right++;
        } else {
            lookup.remove(s.charAt(left));
            left++;
        }
        max = Math.max(right-left, max);    

    }
    return max;       
    }
}