// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Uses Two stack approach
Stack 1 to push all elements
Stack 2 to push all minimum elements ie push only the element smaller than the current element in the stack2
Get the top most element as the Minimum from Stack 2
*/
class MinStack {
    Stack<Integer> stack; //Stack to store all elements
    Stack<Integer> minStack; //Stack to store minimum element

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        //every element to the stack
        stack.push(val);
        // if the value to be pushed is less than the current val in minStack push the value
        if (minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
    }
    
    public void pop() {
        //pop the element from the stack
        int removed = stack.pop();
        if (removed == minStack.peek()) {
            // if the popped stack element matches the minstack top element pop from minStack
            minStack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek(); //get the top element from main stack
        
    }
    
    public int getMin() {
        return minStack.peek(); //get the minimum element from Min Stack
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
