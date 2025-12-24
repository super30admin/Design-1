//Approach was to have a helper stack called minStack
//Store minimum values in that stack
//while pushing values in normal stack, we will cpmare values in minStack and then store at the top

class MinStack {
    
    Stack <Integer> stack;
    Stack <Integer> minStack;
    public MinStack() {
        stack= new Stack<>();
        minStack= new Stack<>();
    }
    
    public void push(int val) {
        //pushes val to normal stack
        stack.push(val);
        //we will only push values in minStack if it is empty or value is less than already stored value in minStack
        if (minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }
        
    }
    
    public void pop() {
        //during pop, we will pop from both stacks
        int poppedValue= stack.pop();

        if(poppedValue==minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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