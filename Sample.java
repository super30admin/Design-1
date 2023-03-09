// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MinStack {
    Stack <Integer> st = new Stack<>();
    Stack <Integer> minStack = new Stack<> ();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        minStack.push(min);
    }
    
    public void push(int val) {
        st.push(val); // to find a min value in stack
        if (val<min){
            min = val;
        }
        minStack.push(min);
    }
    
    public void pop() {
        st.pop(); // to remove the value from stack
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return st.peek(); // to look at the value in stack
        
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