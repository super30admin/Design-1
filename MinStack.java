package leetCode;

import java.util.Stack;

class MinStack {
    
        Stack<Integer> st;
        Stack<Integer> minSt;
        int min = Integer.MAX_VALUE;
    public MinStack() {
        this.st = new Stack<>();
        this.minSt= new Stack <>();
        this.minSt.push(min);    
    }
    
    public void push(int val) {
        //to check for min value
        min = Math.min(min,val);
        this.st.push(val);
        this.minSt.push(min);
    }
    
    public void pop() {
         this.st.pop();
         this.minSt.pop();
         min = this.minSt.peek();
        
        
    }
    
    public int top() {
        return this.st.peek();
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