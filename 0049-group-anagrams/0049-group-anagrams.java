class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // first sort each string 
        // then put them in hashmap with key as sorted and value as original 
        // then  lookup and create result;
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> lookup = new HashMap<>();
        for(String s : strs) {
            char[] s1 = s.toCharArray();
            Arrays.sort(s1);
            String t = new String(s1);
            if(!lookup.containsKey(t)) {
                List<String> values = new ArrayList<>();
                values.add(s);
                lookup.put(t,values);
            } else {
                lookup.get(t).add(s);
            }
        }

        return new ArrayList<>(lookup.values());
    }
}