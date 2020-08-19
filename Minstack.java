// Time Complexity : O(1) for all operations 
// Space Complexity :  O(2n) = O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;

    /** initialize your data structure here. */
    public MinStack() {
        
        stack = new Stack();
        minstack = new Stack();
        
        
    }
        // Push elements into the stack
    // check if the stack is empty or x value is compared against the minstack value 
    // Add that compared value to the minstack
    public void push(int x) {
        stack.push(x);
        if(minstack.isEmpty() || x <= minstack.peek())
            minstack.push(x);
        
        
    }
   // first pop the element from stack
    // then compare this value with minstack top element and remove it
    public void pop() {
        int x = stack.pop();
        if (x == minstack.peek())
            minstack.pop();
        
    }
    //Gets the topmost element
    public int top() {
        return stack.peek();
        
    }
    // Fetches the min value which is the peek value in the minstack 
    public int getMin() {
        return minstack.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
    }
    
