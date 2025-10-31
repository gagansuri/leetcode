class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minstack;

    public MinStack() {
        this.stack =   new ArrayDeque<>();
        this.minstack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minstack.isEmpty()) {
            minstack.push(val);
        } else if(val <= minstack.peek()) {
            minstack.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == minstack.peek()) minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */