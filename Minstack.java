// Time Complexity : All operations have O(1) complexity
// Space Complexity : O(n) space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach
// Used two stacks, one as the main stack to store values and the other one with the minimum at that push. 
class MinStack {

    Stack<Integer> s;
    Stack<Integer> minElts;
    int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE; //put infinity as the min value
        this.s = new Stack<>();
        this.minElts = new Stack<>();
        this.minElts.push(min);
    }
    
    public void push(int val) {
        //Push the value in stack and the corresponding minimum in the minElts stack
        this.s.push(val); 
        min = Math.min(min,val);
        this.minElts.push(min);
        
    }
    
    public void pop() {
        //Pop the value from the stack and the corresponding minimum from minElts stack, update the minimum to the top of minElts stack
        this.s.pop();
        this.minElts.pop();
        min = minElts.peek();
        
    }
    
    public int top() {
        //used inbuilt stack DS
        return this.s.peek();        
    }
    
    public int getMin() {
        //return min
        return this.min;
        
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