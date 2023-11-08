//Time Complexity: O(1) - push,pop,top,getMin functions
//Space Complexity: O(1) - push,pop,top,getMin functions
class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        st = new Stack<>();
        minSt = new Stack<>();
        minSt.push(min);
    }
    
    public void push(int val) {
        if(val <= min ){
            minSt.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
        if(min == st.pop()){
            min = minSt.pop();
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