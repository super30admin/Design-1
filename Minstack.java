// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No.
// Your code here along with comments explaining your approach

The approach used in the following solution is to keep track of the minimum value. 

And we will get minimum value by checking if pop value is equal to min, which makes the time complexity of getting the minimum value O(1).  


class MinStack {

    int min = Integer.MAX_VALUE;
    Stack <Integer> stack = new Stack<>();
    
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        
        if (x <= min)
        {
            stack.push(min);
            min = x;
        }
        stack.push(x);

    }
    
    public void pop() {
        
        int pop = stack.pop();
        
        if (pop == min)
        {
            min = stack.pop();
        }
    
    }
    
    public int top() {
        
        return stack.peek();
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

