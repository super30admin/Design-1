// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
I have initialized a stack of integer arrays and store each element along with the corresponding minimum element in the stack so far
for that particular element. Before I push each value and minimum pair, I check if the current value is less than the minimum element so 
far. If yes, I update the minimum element with the value. Similarly while popping, I check if the popped value is the minimum element, if yes
I update the minimum value with the minimum value corresponding with the top element or Int32.MaxValue if the stack is empty.
*/

public class MinStack
{
    Stack<int[]> minStack;
    int minimumSoFar;

    public MinStack()
    {
        minStack = new();
        minimumSoFar = Int32.MaxValue;
    }

    public void Push(int val)
    {
        if (val < minimumSoFar)
        {
            minimumSoFar = val;
        }

        minStack.Push(new int[] { val, minimumSoFar });
    }

    public void Pop()
    {
        if (minimumSoFar == minStack.Pop()[0])
        {
            if (minStack.Count != 0)
            {
                minimumSoFar = GetMin();
            }

            else
            {
                minimumSoFar = Int32.MaxValue;
            }
        }
    }

    public int Top()
    {
        return minStack.Peek()[0];
    }

    public int GetMin()
    {
        return minStack.Peek()[1];
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