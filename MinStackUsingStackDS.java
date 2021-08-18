class MinStackUsingStackDS {

    /** initialize your data structure here. */
    //stack to insert all the elements
    Stack<Integer> stack;
    //Stack to push the minimum element;
    Stack<Integer> minStack;
    //to keep track of minimum value
    int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack = new Stack<>();
        minStack.push(min);
    }
    
    public void push(int val) {
        //find the minimum of the value to be pushed to the stack and the current minimum
        min = Math.min(min, val);
        minStack.push(min);
        stack.push(val);
    }
    
    public void pop() {
        minStack.pop();
        //when we pop from the min stack, we have to adjust out min pointer
        min = minStack.peek();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

