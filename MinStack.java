// Time complexity: O(1) for all operations
// Space complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Implement using single stack
import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    int minValue;
    public MinStack() {
        stack = new Stack<>();
        minValue = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (val <= getMin()) { // Consider the case when current min and previous min are same
            stack.push(getMin()); // push previous minimum value
            minValue = val; // update new minimum value
        }
        stack.push(val); // push the value
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        if (stack.peek() == getMin()) {
            stack.pop();
            minValue = stack.pop(); // update the new minValue
        } else {
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minValue;
    }
    // Driver method to test above 
    public static void main(String args[]) throws Exception 
    { 
        // Test 1
        MinStack ob1 = new MinStack(); 
        ob1.pop(); // java.util.EmptyStackException
        
        // Test 2
        MinStack ob2 = new MinStack();
        ob2.push(1);
        ob2.push(7);
        System.out.println(ob2.getMin()); // 1
        System.out.println(ob2.top()); // 7
        ob2.pop();
        System.out.println(ob2.top()); // 1
        ob2.pop();
        System.out.println(ob2.getMin()); // Integer.MAX_VALUE

        // Test 3
        MinStack ob3 = new MinStack();
        ob3.top(); // java.util.EmptyStackException

        // Test 4
        MinStack ob4 = new MinStack();
        ob4.getMin(); // Integer.MAX_VALUE
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