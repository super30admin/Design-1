//  Time Complexity O(1) for PUSH, POP, TOP, GETMIN. Also avg space complexity O(1)
// Approach 
// While pushing we check for condition if the pushing value is less than current minimum, we push both the min and the value changing the min flag to new min.
// While poping we check for if the min value equals current pop element we update the minimun flag. 

class MinStack {
private Stack<Integer> st;
private int min;
    
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
         
    }
    
    public void push(int val) {
        if(val<= min){
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