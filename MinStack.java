// Time Complexity : O(1) for push, pop and getMin
// Space Complexity : O(n) for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    MinStack minStack;
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(val <= min){
            // Push old min
            // Update the min
            stack.push(min);
            min = val;
        }
        stack.push(val);

    }
    
    public void pop() {
        if(!stack.isEmpty()){
            int poppedVal = stack.pop();
            if(poppedVal == min){
                min = stack.pop();
            }
        }

    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
