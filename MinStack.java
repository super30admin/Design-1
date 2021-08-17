// Time Complexity : O(1) for push(), pop(), top() and getMin()
// Space Complexity : O(N) where N is the elements in the stack.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MinStack {
    
    int min;
    Stack<Integer> s;    
    /** initialize your data structure here. */
    
    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min){
            s.push(min);
            min = val;
        }
        s.push(val);
        
    }
    
    public void pop() {
        if(min == s.pop()){ 
            min = s.pop();
        }
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