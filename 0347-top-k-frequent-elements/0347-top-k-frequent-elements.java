class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      //count the frequency of numbers

      Map<Integer, Integer> freqMap = new HashMap<>();
      PriorityQueue<Integer> countHeap = new PriorityQueue<>((a,b) -> {
        return Integer.compare(freqMap.get(b),freqMap.get(a));});
      
      for(int i = 0 ; i < nums.length; i++) {
        freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
      }

      for(int i : freqMap.keySet()) {
        countHeap.add(i);
      }  

    int[] res = new int[k];
    for(int i = 0 ; i < k ; i++) {
        res[i] = countHeap.remove();
    }
    return res;
    }
}