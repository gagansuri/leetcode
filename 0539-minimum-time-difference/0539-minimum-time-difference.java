class Solution {
    public int findMinDifference(List<String> timePoints) {
        // convert hours to minutes
        // add to each minute buckets 1440 (24*60 = 1440) as true which is found
        // calculate the difference between minutes and calculate min
        boolean[] timeBuckets = new boolean[1440];
        for(String s: timePoints) {
            int hour = Integer.parseInt(s.split(":")[0]);
            int min = Integer.parseInt(s.split(":")[1]);
            int minutes = hour*60+min;
            if(timeBuckets[minutes] == true) return 0;

            timeBuckets[minutes] = true;
        }
    
    int min = Integer.MAX_VALUE, pre = -1, current = -1, first = -1;
    for(int i = 0; i < 1440; i++) {
        if(timeBuckets[i] == false) continue;

        if(first == -1) {
            first = i;
            pre = i;
            current = i; 
        } else {
            current = i;
            min = Math.min(min, current - pre);
            pre = current;
        }
    }

    min = Math.min(min, 1440 - current+first);
    return min;
}
}