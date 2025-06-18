class MinStack {

    Stack<Integer> s1;
    int min;
    public MinStack() {
        this.s1 = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min){
            s1.push(min);
            min = val;
        }
        s1.push(val);
    }
    
    public void pop() {
        int n = s1.pop();
        if(n == min){
            min = s1.pop();
        }
    }
    
    public int top() {
         return s1.peek(); 
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
