class MedianFinder {
    private PriorityQueue<Integer> minHeap, maxHeap; 
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) -> {return Integer.compare(a,b);});
        maxHeap = new PriorityQueue<>((a,b) -> {return Integer.compare(b,a);}); 
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.peek());
        minHeap.remove();

        if(minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.peek());
            maxHeap.remove();
        }
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek())*0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */