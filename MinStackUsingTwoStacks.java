// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
// The mainStack stores all values normally, while the minStack tracks the minimum element by only pushing values that are less than or equal to its current top.
// When you pop, if the removed value is the current minimum, it is popped from the minStack as well to keep the minimums synced with the remaining data.

import java.util.Stack;

class MinStackUsingTwoStacks {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStackUsingTwoStacks() {
        mainStack = new Stack<>();
        minStack = new Stack<>();    
    }
    
    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) 
            minStack.push(val);
    }
    
    public void pop() {
        int poppedValue = mainStack.pop();
        if (poppedValue == minStack.peek()) 
            minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

 