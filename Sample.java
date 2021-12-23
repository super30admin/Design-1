import java.util.Stack;

// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;
    public MinStack() {
        stack = new Stack<>(); 
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int val) {
    min= Math.min(min,val);
       if(val <= min){
           stack.push(val);
           min = val;
           minStack.push(min);
       } else{
           stack.push(val);
           minStack.push(min);
       }
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