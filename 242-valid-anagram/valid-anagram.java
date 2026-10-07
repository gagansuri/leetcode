class Solution {

    public boolean isAnagram(String s, String t) {
        if((s == null && t == null) || (s.length() == 0 && t.length() == 0)) return true;
        
        if(s.length() != t.length()) return false;

        char[] lookup = new char[26];

        for(char c : s.toCharArray()) {
            lookup[c-'a']++;
        }
        for(char c : t.toCharArray()) {
            lookup[c-'a']--;
            if(lookup[c - 'a'] < 0 ) return false;
        }

        for(int i = 0 ; i < 26; i++) {
            if(lookup[i] != 0) return false;
        }

        return true;
    }
}