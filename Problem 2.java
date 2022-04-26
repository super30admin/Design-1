//time complexity=0(1)
//space comlexity=0(1)

// This solution enables u to have a stack which has all the elements without extra as second stack is used for minimum

import java.util.Stack;

class MinStack {

    Stack<Integer> stack = new Stack();  //initializing two different stacks, one for minimum values and the other for all elements
    Stack<Integer> min_vals = new Stack();
    
    public void push(int x) {
        if(min_vals.isEmpty() || x<=min_vals.peek()){  //to push the minimum values into the min_value stack
            min_vals.push(x);
        }
        stack.push(x); //push all the elements into stack as well
    }
    
    public void pop() {
        if(stack.peek().equals(min_vals.peek())){ //if the top element of min_vals is same as stack, we can pop out both the elements of min and stack
            min_vals.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_vals.peek();
    }
}
