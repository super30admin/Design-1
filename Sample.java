// Time Complexity : O(1) for all operations 
// Space Complexity :  O(2n) = O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;

    /** initialize your data structure here. */
    public MinStack() {
        
        stack = new Stack();
        minstack = new Stack();
        
        
    }
    // Push elements into the stack
    // check if the stack is empty or x value is compared against the minstack value 
    // Add that compared value to the minstack
    public void push(int x) {
        stack.push(x);
        if(minstack.isEmpty() || x <= minstack.peek())
            minstack.push(x);
        
        
    }
    // first pop the element from stack
    // then compare this value with minstack top element and remove it
    public void pop() {
        int x = stack.pop();
        if (x == minstack.peek())
            minstack.pop();
        
    }
    