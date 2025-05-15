/*
   Time complexity: O(1)
   Space complexity: O(n)

   Approach: Using a traditional stack with a modification where we a store a Tuple in the stack solves the problem. Each of the tuples has
             the value to be inserted along with the minimum value encountered till then. When the values till the current minimum are popped
             out, the next tuples have the second minimum, which becomes the current minimum.
*/


public class MinStack {
    Stack<(int num, int min)> stack;
    public MinStack() {
        stack = new();
    }
    
    public void Push(int val) {
        if(stack.Count>0)
        {
            stack.Push((val,Math.Min(val,stack.Peek().min)));
        }
        else
        {
            stack.Push((val,val));
        }
    }
    
    public void Pop() {
        stack.Pop();
    }
    
    public int Top() {
        return stack.Peek().num;
    }
    
    public int GetMin() {
        return stack.Peek().min;
    }
}
