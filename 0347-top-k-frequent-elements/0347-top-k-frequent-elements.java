class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fcm = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a,b) -> Integer.compare(fcm.get(b), fcm.get(a))
        );
        for(int i: nums ) fcm.put(i, fcm.getOrDefault(i,0)+1);
        for(int i : fcm.keySet()) {
            heap.add(i);
        }
        int[] result = new int[k];
        for(int i = 0 ; i < k; i++) {
            result[i] = heap.remove();
        }
    return result;
    }
}