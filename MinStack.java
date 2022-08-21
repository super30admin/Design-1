class MinStack {
    private Stack<Integer> minstack;
    private int min;

    public MinStack() {
        this.minstack = new Stack<>();
        this.min = Integer.MAX_VALUE; 
    }
    
    public void push(int val) {
        if (min >= val){
            minstack.push(min);
            min = val;
        }
        minstack.push(val);
    }
    
    public void pop() {
        if (min == minstack.pop()){
            min = minstack.pop();
        }
    }
    
    public int top() {
        return minstack.peek();
    }
    
    public int getMin() {
        return min;     
    }
}