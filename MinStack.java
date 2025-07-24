// Your code here along with comments explaining your approach
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;  // Main stack to store all values
    private Stack<Integer> minStack; // Auxiliary stack to track the minimum value at each level

    public MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val){
        stack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop(){
        if(stack.isEmpty()){
            return;
        }

        int removed = stack.pop();
        if(removed == minStack.peek()){
            minStack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}


