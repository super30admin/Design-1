import java.io.*;
/* Algorithm:
    1. Single stack to store data and min number
    2. Variable to store current min
    3. If min is same as value to insert or pop then add/pop twice
    
    // Time Complexity : O(1) // Add, Remove, Contains
    // Space Complexity : O(n)
*/
class MinStack {

    Stack stack;
    int min;
    
    public MinStack() {
        stack = new Stack();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min)
        {
            //Push the min and value to stack and update min
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(min == stack.pop())
        {
            min = stack.pop(); // pop twice
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
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