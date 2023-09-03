// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Design HashSet

import java.util.Stack;

class MinStack {
    Stack<Integer> myStack;
    Stack<Integer> minStack;
    int min;
    public MinStack() {
        min = Integer.MAX_VALUE;
        myStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(min);
    }
    
    public void push(int val) {
        if(min > val ){
            min = val;
        }
        myStack.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        myStack.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return myStack.peek();
    }
    
    public int getMin() {
        return min;
        
    }

     public static void main(String[] args) {
        MinStack stack = new MinStack();

        // Push elements onto the stack
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(7);

        // Get the top element and the minimum element in the stack
        System.out.println("Top element: " + stack.top()); // Should print 7
        System.out.println("Minimum element: " + stack.getMin()); // Should print 2

        // Pop an element and check the minimum element again
        stack.pop();
        System.out.println("After popping, minimum element: " + stack.getMin()); // Should print 2

        // Pop all elements and check if the stack is empty
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("Is the stack empty? " + stack.isEmpty()); // Should print true
    }
}
