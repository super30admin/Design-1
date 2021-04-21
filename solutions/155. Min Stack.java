class MinStack {
    
    private Stack<Integer> base;
    private Stack<Integer> minStatus;
    int min;
​
    /** initialize your data structure here. */
    public MinStack() {
        base=new Stack<Integer>();
        minStatus=new Stack<Integer>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        base.push(val);
        if(min>val){
            min=val;
            minStatus.push(val);
        }else{
            minStatus.push(min);
        }
    }
    
    public void pop() {
        base.pop();
        minStatus.pop();
        if(!minStatus.isEmpty()){
            min=minStatus.peek();
        }else{
            min=Integer.MAX_VALUE;
        }
    }
    
    public int top() {
       return base.peek();
    }
    
    public int getMin() {
        return min;
    }
}
​
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
