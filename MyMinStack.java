// Time Complexity : push -> 0(1), pop -> 0(1), top -> 0(1), getMin -> 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Maintain a regular stack and another stack that holds only the minimum values as they come.
//            If the new element being pushed in the stack is smaller or equal to the top of min stack, push it in the min stack as well.
//            If an element is being popped from the main stack, 
//              it should be popped from the top of the min stack also (if it exists at the top of min stack)

// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = new Stack<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        st.push(val);
        if (min.peek() >= val)
            min.push(val);
    }

    public void pop() {
        int val = st.pop();
        if (min.peek() == val)
            min.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
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