import java.util.Stack;

class MinStack {

/*Time Complexity:
 * push() : O(1);
 * pop() : O(1);
 * top() : O(1);
 * getMin() : O(1);
 * 
 * Space Complexity: O(n);
 * 
 * Executed Succesfully in leetcode
 */
    Stack<Integer> st;
    Stack<Integer> minst;
    int min;
 
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minst = new Stack<>();
        this.minst.push(min);
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        this.st.push(val);
        this.minst.push(min);
        
    }
    
    public void pop() {
        this.st.pop();
        this.minst.pop();
        min = minst.peek();
        
    }
    
    public int top() {
        return this.st.peek();
        
    }
    
    public int getMin() {
        return this.minst.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 * vszdfh
 */