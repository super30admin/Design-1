// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



// Your code here along with comments explaining your approach
/**
 * Designed a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Each time the minimum value is updated, the previous minimum is stored in the stack along with the new value and current minimum.
 * Whenever the popped value is the current minimum, the previous minimum is retrieved from the stack.
 */
import java.util.Stack;
class MinStack {
        Stack<Integer> minSt;
        int minvalue;

    public MinStack() {
        this.minSt = new Stack<>();
        this.minvalue=Integer.MAX_VALUE;
        
    }
    
    public void push(int val) {
        int temp;
        if(minSt==null)
        {
            minSt.push(Integer.MAX_VALUE);
        }
        else
        {
            temp=minvalue;
            minvalue=Math.min(val,minvalue);
            if(minvalue==val)
            {
                minSt.push(temp);
                minSt.push(val);
            }
            else
            {
                minSt.push(val);
            }
        }
    }
    
    public void pop() {
        int poppedvalue=minSt.pop();
        if(poppedvalue==minvalue)
            minvalue=minSt.pop();

        
    }
    
    public int top() {
        
        return minSt.peek();
    }
    
    public int getMin() {
        return minvalue;
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
