class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // sort by start time
       
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) ->
            Integer.compare(a[1],b[1]));
        int[] pre = intervals[0];
        minHeap.add(pre);
        for(int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i] ;
            int[] before = minHeap.peek();
            //System.out.println("curr[0][]" + curr[0] + " : " + curr[1] + " :   before: "+ before[0] + before[1] + " > " + (curr[0] >= before[1]));
            if(curr[0] >= before[1]) {
                minHeap.poll();
            }
            minHeap.add(curr);       
        }
        return minHeap.size();
    }
}