//Time Complexity:Best Case: 0(1) worst Case: O(N)
// Space Complexity: O(N)
class MinStack {
    Stack<Integer> stack ;
    Stack<Integer> minStack ;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        if( minStack.peek() > val){
            stack.push(val);
            minStack.push(val);
        } else if (minStack.peek() <= val){
            stack.push(val);
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
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