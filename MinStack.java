//Time complexity for push, pop, top, pop, getMin o(1)
//Space complesity o(n)

//I am using 2 stacks, one stack-pimary stack will hold all the elements in chronological order(LIFO), secondary stack will hold minimum value pushed into primary stack till then
class MinStack {
    
    Stack<Integer> primary;
    Stack<Integer> secondary;
    
    public MinStack() {
        primary = new Stack();
        secondary = new Stack();
    }
    
    public void push(int val) {
        if(secondary.isEmpty()){
            secondary.push(val);
        } else {
            if(secondary.peek() < val){
                secondary.push(secondary.peek());
            } else {
                secondary.push(val);
            }
        }
        primary.push(val);
    }
    
    public void pop() {
        //pop from both primary and secondary stacks
        primary.pop();
        secondary.pop();
    }
    
    public int top() {
        if(primary.isEmpty()) return Integer.MAX_VALUE;
        else return primary.peek();
    }
    
    public int getMin() {
        //top value of secondary stack is always the minimum value entered
        if(secondary.isEmpty()) return Integer.MAX_VALUE;
        else return secondary.peek();
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
