import java.util.Stack;

class MinStack_2 {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public MinStack_2() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        minStack.push(min);
    }
    
    public void push(int x) {
        
        if(x < min){
            min = x;
        }
        
        minStack.push(min);
        stack.push(x);
    }
    
    public void pop() {
        
        stack.pop();
        minStack.pop();
        
        min = minStack.peek();
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
