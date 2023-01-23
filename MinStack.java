// Time Complexity : O(1)
// Space Complexity : O(N) where N is the number of elements pushed to the stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


import java.util.Stack;

/**
 * @author akhilreddy619
 * The stack store a pair of integers whenever a new element is pushed. 
 * One is the actual element and the 2nd one is the minimum of the current
 * element and the peek pair's 2nd element.
 * for Push: if stack is empty, push the pair of {val, val} else,
 * push the pair with {val, min(val, peek pair's 2nd element}.
 * for Pop: if stack is not empty, pop the top pair.
 * for Peek: if stack is not empty, return the peek pair's 1st element.
 * for getMin: if stack is not empty, return the peek pair's 2nd element.
 */
class MinStack {
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new int[] {val, val});
        } else {
            int[] pair = stack.peek();
            int min = pair[1];
            stack.push(new int[] {val, Math.min(val, min)});
        }
    }
    
    public void pop() {
        if(stack.isEmpty())
            return;
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
