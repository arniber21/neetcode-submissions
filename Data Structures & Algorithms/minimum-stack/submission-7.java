class MinStack {
    // Heap backed by a stack (?)
    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;
    
    public MinStack() {
        this.stack = new LinkedList<Integer>();
        this.minStack = new LinkedList<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.size() == 0 || minStack.peek() >= val) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
