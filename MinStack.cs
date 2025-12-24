// Time Complexity : O(1)
// Space Complexity :O(n) - Extra stacks
// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this :
//NA

// Your code here along with comments explaining your approach
// I have maintained two stack one is original and other one is Min stack
// I will add vals in stack and for min stack compare the values like if the new value is less than top element of the stack then only insert it in the min stack else insert last min value.

public class MinStack
{

    private Stack<int> stack;
    private Stack<int> minStack;
    public MinStack()
    {
        stack = new Stack<int>();
        minStack = new Stack<int>();
    }

    public void Push(int val)
    {
        stack.Push(val);

        if (minStack.Count == 0 || val < minStack.Peek())
        {
            minStack.Push(val);
        }
        else
        {
            minStack.Push(minStack.Peek());
        }
    }

    public void Pop()
    {
        stack.Pop();
        minStack.Pop();
    }

    public int Top()
    {
        return stack.Peek();
    }

    public int GetMin()
    {
        return minStack.Peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.Push(val);
 * obj.Pop();
 * int param_3 = obj.Top();
 * int param_4 = obj.GetMin();
 */