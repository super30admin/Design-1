import java.io.*;
import java.lang.*;
//Time complexity: O(1)
//Space complexity: O(n)
class MinStack {
    Stack<Integer> st=new Stack<>();
    Stack<Integer> minst=new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        st.push(val);
        if(minst.isEmpty() || val<=minst.peek()){
            minst.push(val);
        }
        
    }
    
    public void pop() {
        if(st.peek().equals(minst.peek())){
            minst.pop();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
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
