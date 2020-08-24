import java.util.Stack;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class MinStack {
    int min;
    Stack<Integer> s; 
    /** initialize your data structure here. */
    public MinStack() {
         min = Integer.MAX_VALUE;
         s = new Stack<>(); 
    }
    
    public void push(int x) {
        if(x <= min)
        {
            s.push(min);
            s.push(x);
            min = x;
            return;
        }
        s.push(x);
    }
    
    public void pop() {
        int x = s.pop();
        if(min == x)
        {
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */