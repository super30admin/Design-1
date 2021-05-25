// Time Complexity : PUSH - O(1), POP - O(1), TOP - O(1), getMin - O(1)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to think about the min value to be returned when the stack gets empty after executing PUSH, POP, TOP, getMin in any order.


// Your code here along with comments explaining your approach

// For every element getting added to the stack we store the min value for that element using an array of two elements i.e the actual value and the min value
// The min value is based on the elements currently present in the stack
// tThe min value gets updated every time a new val is pushed onto the stack
// if the stack is empty, I just return the Integer.MIN_VALUE when getMin is called,
class MinStack {
    Stack<int[]> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min = Math.min(val, getMin()); 
        stack.push(new int[]{val, min});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.isEmpty() ? -1 :  stack.peek()[0];
    }
    
    public int getMin() {
        return stack.isEmpty() ? Integer.MAX_VALUE :  stack.peek()[1];
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
