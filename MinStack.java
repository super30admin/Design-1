import java.util.Stack;

// Time Complexity : O(1) for push pop getTop getMin
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack {
    
    Stack<Integer> s;
    int min;

    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE; //initialize to max value
        
    }
    
    public void push(int val) {
        if(val<=min)
        {
            s.push(min); //save the old min
            min=val;
        }
        s.push(val); // push new val
        
        
    }
    
    public void pop() {
        if(s.pop()==min){
            min = s.pop(); //pop previous min
        }
    }
    
    public int top() {
        return s.peek(); // return top element
        
    }
    
    public int getMin() {
        return min;   // return current minimum element in stack
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
