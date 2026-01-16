class MedianFinder {
    private PriorityQueue<Integer> minHeap, maxHeap; 
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) -> {return Integer.compare(a,b);});
        maxHeap = new PriorityQueue<>((a,b) -> {return Integer.compare(b,a);}); 
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        if((minHeap.size() - maxHeap.size()) > 1) {
            int n = minHeap.remove();
            maxHeap.add(n);
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek() ) / 2.0;
        }
        return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */