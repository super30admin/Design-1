class MinStack {

    Stack<Integer> s;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        this.s = new Stack<Integer>();
       
    }
    
    public void push(int val) {
        if(val<=min){
            stack.push(min);
            min = val;
        }

        stack.push(val);
        
    }
    
    public void pop() {
        if(s.pop()==min){
            min =s.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}