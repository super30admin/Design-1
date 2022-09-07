// Time Complexity : Add: O(1), Remove: O(1), Contains: O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

//Problem 2
import java.util.Stack;
public class MinStack {
    int min;
    Stack<Integer> primaryStack;
    Stack<Integer> minStack;

    public MinStack() {
        //Initialized values
        min = Integer.MAX_VALUE;
        primaryStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(min);
    }

    public void push(int val) {
        // find minimum by inbuilt method Math.min
        min = Math.min(min, val);
        primaryStack.push(val);
        minStack.push(min);
    }

    public void pop() {
        primaryStack.pop();
        minStack.pop();
        // set min to top of the minStack
        min = minStack.peek();
    }

    public int top() {
        return primaryStack.peek();
    }

    public int getMin() {
        return min;
    }
}