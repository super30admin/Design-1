import java.util.Stack;


//one is one mapping solution
class MinStack {

    public Stack<Integer> st = new Stack<>();
    public Stack<Integer> minSt = new Stack<>();

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
        
    }
    
    public void push(int val) {
        st.push(val);
        if (minSt.isEmpty() || val <= minSt.peek()) {
        minSt.push(val);
        }
        else 
        {
            minSt.push(minSt.peek());
        }
     
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
  
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return minSt.peek();
        
    }
}



// Solution 2

//considering only one stack and assigning min val
class MinStack2 {
    Stack<Integer> st;
    int min;
    public MinStack2() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE; 
    }
    
    public void push(int val) {
        if(val<=min){
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
        if(st.pop() == min){
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */