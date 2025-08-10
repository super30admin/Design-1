// Time Complexity : For all operations: O(1)
// Space Complexity : For all operations: O(1) 
import java.util.Stack;
class MinStack {

    Stack<int[]> stack; // insert as [val, min]
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {

        if (stack.isEmpty()) {
            stack.push(new int[] {val, val});
            return;
        }

        int min = stack.peek()[1];
        if (val < min) {
            min = val;
        }
        stack.push(new int[] {val, min});
    }
    
    // not checking not empty conditions for pop, top and getMin 
    // as the problem question guarantees it.
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}