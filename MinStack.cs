using System;

/// <summary>
/// Summary description for Class1
/// </summary>
public class MinStack
{
    Stack<int> minStack = new Stack<int>();
    Stack<int> MainStack = new Stack<int>();
    public MinStack()
    {

    }

    public void Push(int val)
    {
        MainStack.Push(val);
        if (minStack.Count == 0)
        {
            minStack.Push(val);
        }
        else
        {
            if (minStack.Peek() >= val)
            {
                minStack.Push(val);
            }
        }

    }

    public void Pop()
    {
        var x = MainStack.Pop();

        if (minStack.Peek() == x)
            minStack.Pop();
    }

    public int Top()
    {
        return MainStack.Peek();
    }

    public int GetMin()
    {
        return minStack.Peek();
    }
}