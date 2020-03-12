class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        if(minStack.isEmpty()){
            minStack.push(x);
        }else
            minStack.push(minStack.peek() > x ? x : minStack.peek() );

        stack.push(x);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    /**
     * Time Complexity - O(1) - all operations
     * Space Complexity - O(2n) ~ O(n) - 2 stacks with n elements
     */
}