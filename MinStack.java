//time complexity - O(1). 
//The approach for Min stack involves 2 stacks. One does normal stack operations the other one minstack keeps track of min element.
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;
    private int min;

    public MinStack() {
        this.stack = new Stack<>();
        this.minstack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        this.minstack.push(min);
        
    }
    
    public void push(int val) {
        min = Math.min(val, min);
        stack.push(val);
        minstack.push(min);

    }
    
    public void pop() {

        stack.pop();
        minstack.pop();
        min = minstack.peek();
       
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
       return min;

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */