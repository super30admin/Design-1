import java.io.*;
    
    // Time Complexity : O(1) 
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

