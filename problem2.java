// Problem 2:Design MinStack (https://leetcode.com/problems/min-stack/)


// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach
// approach: An integer stack was taken with an integer variable. the logic was coded in such a way that if there is any change in the value of minimum the historical value of minimum was being tracked in the same stack. The retrieval was also altered to retrieve the old minimum if the currect minimum is being dicarded or is no longer valid.


class MinStack {

    Stack<Integer> s;
    int min;

    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
        
    }
    
    public void push(int val) {
        if(val <= min)
        {
            s.push(min);
            min = val;
        }
        s.push(val);

        
    }
    
    public void pop() {
        if(min == s.pop())
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
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */