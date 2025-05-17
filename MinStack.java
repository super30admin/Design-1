// Time Complexity : O(1)
// Space Complexity : O(n) where n is size of stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Implemented using a stack and a variable to keep track of min.
// For push operation, if key is < min then push the min and key so that we keep a track of min in each push.
// For pop operation, if the top elemnt is min then pop twice and update the min with the second pop because during push we pushed the min first before the key.

class MinStack {
    Stack<Integer> minStack;
    int min;
    public MinStack() {
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (min >= val) {
            minStack.push(min);
            min = val;
        }
        minStack.push(val);
    }
    
    public void pop() {
        if(minStack.peek() == min){
            minStack.pop();
            min = minStack.pop();
            return;
        }
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return min;
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