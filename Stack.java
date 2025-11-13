// Time Complexity :O(1)
// Space Complexity :O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had some issues with the syntax other than that i am good


// Your code here along with comments explaining your approach
//initialized two stacks one for tracking the actual value and one for minimum value
//updated the min in in push and pop because whenever a number comes or goes the min changes
class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minSt.push(min);
    }
    
    public void push(int val) {
        st.push(val);
        min = Math.min(val,min);
        minSt.push(min);
        
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek();
    }
    
    public int top() {
        return st.peek();
        
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