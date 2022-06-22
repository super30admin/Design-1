import java.lang.*;
import java.util.*;

class MinStack {
    Stack<Integer> stack;
    int min;
    
    public MinStack() {
        stack = new Stack();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(min == stack.pop()){
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

