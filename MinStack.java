// Does this work in LeetCode: Yes. 
// I went through Tuesday's video and followed along. 

class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int x) {
        min = Math.min(min, x);
        minStack.push(min);
        st.push(x);
        
    }
    
    public void pop() {
        st.pop();
        minStack.pop();
        min = minStack.peek();
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
