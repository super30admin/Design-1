/* Time Complexity: O(1) */
/* Space Complexity: O(n) */
/* Did this code successfully run on Leetcode : Yes */
/* Any problem you faced while coding this : I faced some syntactical and compilation errors. Also i had to take help from the google solution to proceed with the problem*/


class MinStack {
    
    /*initialized 2 stacks. stack1 is the main stack where all values will be pushed. stack2 is the auxilary stack to store minimum values */
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /*contructor*/
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int val) {
        stack1.push(val);       /* Pushing the values in stack1 */
        if(stack2.isEmpty()){   /*  Checking is stack2 is empty  if yes then it will simply push the value in the stack else  value pushed will be the min value */
            stack2.push(val);
        }
        else{
            stack2.push(Math.min(stack2.peek(),val));
        }
        
    }
    
    public void pop() { /* Pops values from both stack */
        stack1.pop();
        stack2.pop();
    }
    
    public int top() { /* Peeps values from stack1 */
        return stack1.peek();
    }
    
    public int getMin() { /* Returns min value from stack2 */
        return stack2.peek();
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