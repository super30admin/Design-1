// Time Complexity : O(1) for all
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Stack;
class MinStack {
    Stack<Integer> stack ;
    int currMin;
    public MinStack() {
        stack = new Stack<>();
        currMin= Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<=currMin){
            stack.push(currMin);
            currMin = val;
        }
            
         stack.push(val);   
            
    }
    
    public void pop() {
        if(stack.pop()==currMin)
            currMin=stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return currMin;
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