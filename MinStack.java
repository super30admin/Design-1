// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class MinStack {
    //Declaring main stack and Auxiliary stack
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    //Push the element to main stack and min of elemnt and the top element to auxiliary stack
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(x);
        } else {
            stack2.push(Math.min(stack2.peek(), x));
        }
    }
    //pop element from main and auxiliary stack
    public void pop() {
        stack1.pop();
        stack2.pop();
    }
    
    //return Top element as top element of main stack
    
    public int top() {
        return stack1.peek();
    }
    
    //return Min element as top element of auxiliary stack
    
    public int getMin() {
        return stack2.peek();
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
