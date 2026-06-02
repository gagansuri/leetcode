class Solution {

    public boolean isAnagram(String s, String t) {
    // either sort and compare nlogn + n

    // create a frequency map n + n + n O(3n) - O(n)
    if(s == null && t == null) return true;

    if(s == null || t == null ) return false;

    if(s.length() != t.length()) return false;

    Map<Character, Integer> lookup = new HashMap<>();
    for(char c : s.toCharArray()) {
        lookup.put(c, lookup.getOrDefault(c, 0)+1);
    }

    for(char c : t.toCharArray()) {
        if(lookup.containsKey(c)) {
            lookup.put(c, lookup.get(c) - 1);
            if(lookup.get(c) == 0 ) {
                lookup.remove(c);
            }
        } else {
            return false;
        }
    }
        return  lookup.isEmpty();
    }
}