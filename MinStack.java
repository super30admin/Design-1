// Time Complexity : O(1) for all push pop top getMin
// Space Complexity : O(n) where n is the number of elements in the stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none

// Your code here along with comments explaining your approach
//used two stacks, one for storing elements and one for storing the minimum element at each position. 
import java.util.Stack;
class MinStack 
{
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() 
    {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) 
    {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) 
        {
            minStack.push(val);
        } else 
        {
            minStack.push(minStack.peek());
        }
    }

    public void pop() 
    {
        stack.pop();
        minStack.pop();
    }

    public int top() 
    {
        return stack.peek();
    }

    public int getMin() 
    {
        return minStack.peek();
    }
}