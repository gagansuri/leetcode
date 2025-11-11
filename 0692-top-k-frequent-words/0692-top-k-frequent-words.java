class Solution {
    public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> fCM = new HashMap<>();    
    PriorityQueue<String> maxHeap = new PriorityQueue<>(
        (s1,s2) -> fCM.get(s1).equals(fCM.get(s2)) ? s1.compareTo(s2) : fCM.get(s2).compareTo(fCM.get(s1)));
        

    for(String word : words) {
        fCM.put(word, fCM.getOrDefault(word,0)+1);
    }    
    //System.out.println("fcm:"+fCM);
    for(String word : fCM.keySet()) {
        maxHeap.add(word);
        
        
    }
//System.out.print(maxHeap + " ");
List<String> result = new ArrayList<>();
for(int i = 0 ; i < k ; i++) {
    result.add(maxHeap.remove());
}
    return result;

    }
}