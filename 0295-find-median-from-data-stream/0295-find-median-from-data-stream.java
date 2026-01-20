class MedianFinder {
    private PriorityQueue<Integer> leftHeap, rightHeap;
    public MedianFinder() {
        leftHeap = new PriorityQueue<>((a,b)-> {return Integer.compare(b,a);});
        rightHeap = new PriorityQueue<>((a,b)-> {return Integer.compare(a,b);});
    }
    
    public void addNum(int num) {
      // add the number 
        leftHeap.add(num);
        int n = leftHeap.remove();
        rightHeap.add(n);

        if(rightHeap.size() > leftHeap.size()) {
            int n1 = rightHeap.remove();
            leftHeap.add(n1);
        }
      
    }
    
    public double findMedian() {
      if(leftHeap.size() > rightHeap.size()) {
        return leftHeap.peek();
      }
      return (leftHeap.peek() + rightHeap.peek())*0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */