// 155. Min Stack
// S30 Big N Problem #2 {Medium}
// Time Complexity : O(1) to find min; O(1) to insert an element
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Approach 1: Using two stacks
// Stack 1 for elements and Stack 2 to keep a track of previous minimums
class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();
    int min=Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public MinStack() {
        minstack.push(min);
    }
    
    public void push(int x) {
        stack.push(x);
        if(x<min){
            min = x;
        }
        minstack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
        min=minstack.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
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
