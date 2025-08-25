
//Time Complexity O(1)
// Two stacks are used here: 
// - stack1 functions as the normal stack (stores all elements).
// - stack2 functions as the minimum stack (tracks the minimum at each level).
//
// When pushing an element, we check if it is smaller than or equal to the current minimum:  
//   - If yes, push it onto stack2.  
//   - Otherwise, push the current minimum again onto stack2.  
//
// When popping, we remove the top element from both stacks.  
//
// Calling peek() on stack1 gives the top element of the stack.  
// Calling peek() on stack2 always gives the current minimum element of the stack.  
//
// This approach ensures all operations (push, pop, top, getMin) run in O(1) time.  
// Code accepted on LeetCode.
import java.util.*;

class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    MinStack() {
       this.stack1= new Stack<>();
       this.stack2= new Stack<>(); 
    }
    
    void push(int val) {
        stack1.push(val);

        if (stack2.isEmpty() || val < stack2.peek()) {
            stack2.push(val);
        } else {
            stack2.push(stack2.peek());
        }
        
    }
    
    void pop() {
        stack1.pop();
        stack2.pop();
    }
    
    int top() {
        int x= stack1.peek();
        return x;
    }
    
    int getMin() {
        int x= stack2.peek();
        return x;
    }
};