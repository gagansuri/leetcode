class Solution {
    public int[][] merge(int[][] intervals) {
        //sort all the intervals on starting time
        Arrays.sort(intervals, (p1,p2) -> Integer.compare(p1[0],p2[0]));
        
        List<int[]> merged = new ArrayList<>();

        int[] pre = intervals[0];
        for(int i = 1 ; i < intervals.length; i++) {
            if(intervals[i][0] <= pre[1] ) {
                pre[1] = Math.max(pre[1],intervals[i][1]);
            } else {
                merged.add(pre);
                pre = intervals[i];
            }
        }
        merged.add(pre);
        return merged.toArray(new int[merged.size()][]);
    }
}