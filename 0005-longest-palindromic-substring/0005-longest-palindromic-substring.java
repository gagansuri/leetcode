class Solution {
    public String longestPalindrome(String s) {
        // take each character go its left and right

        String max = "";
        for(int i = 0 ; i < s.length(); i++) {
            String odd = palin(s, i, i);
            String even = "";
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                even = palin(s, i , i+1);
            }

            if(even.length() > odd.length()) {
                if(max.length() < even.length()) {
                    max = even;
                }
            } else {
                if(max.length() < odd.length()) {
                    max = odd;
                }
            }
       

        }
     return max;
    }

    public String palin(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left+1,right);
    }
}