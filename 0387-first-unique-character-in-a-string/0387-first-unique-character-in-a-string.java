class Solution {
    public int firstUniqChar(String s) {
        int counts[] = new int[26];
        for(char c : s.toCharArray()) {
            counts[c - 'a']++; 
        }
         for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if(counts[c-'a'] == 1) {
                return i;
            } 
        }
    return -1;
    }
    
    }