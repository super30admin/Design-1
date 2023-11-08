// Time Complexity : push: O(1), pop: O(1), top: O(1), getMin: O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Maintain a variable min which will have current minimum values
// In case of push, If the incoming element values is lesser than the min value, push the current min and update the min value. Then push the element
// In case of pop, If the popped value is equal to min value, update the min value to top of stack value and pop it.

class MinStack {
    int min;
    Stack<Integer> st;

    public MinStack() {
        min = Integer.MAX_VALUE;
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(val <= min){
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
        if(min == st.pop()){
            min = st.pop();
        }
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