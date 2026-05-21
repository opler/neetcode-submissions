class MinStack {
    Stack<Integer> nStack;
    Stack<Integer> minStack;

    public MinStack() {
        nStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        nStack.push(val);
        if (!minStack.isEmpty() && val <= minStack.peek()) {
            minStack.push(val);
        } else if (minStack.isEmpty()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = nStack.pop();
        if (!minStack.isEmpty() && val == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return nStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
