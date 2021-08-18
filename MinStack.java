
// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;
    int min;
    
    /** initialize your data structure here. */
    
    public MinStack() {
        //initialize variables in constructor
        s=new Stack<>();
        min=Integer.MAX_VALUE;  
        minStack=new Stack<>();
        minStack.push(min); 
    }
    
    public void push(int val) {
        
            s.push(val);
            min=Math.min(min, val);
            minStack.push(min);
        }
        
    public void pop() {
        s.pop();
        minStack.pop();
        min=minStack.peek();
    }
    
    public int top() {
        return s.peek();
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