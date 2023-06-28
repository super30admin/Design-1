public class MinStack
{
    int min;
    Stack <int> minSt;
    Stack <int> st;
    public MinStack()
    {
        st = new Stack<int>();
        minSt = new Stack<int>();
        min = int.MaxValue;
    }

    public void Push(int val)
    {
        min = Math.Min(val, min);
        minSt.Push(min);
        st.Push(val);
    }

    public void Pop()
    {
        st.Pop();
        minSt.Pop();
        min = minSt.Peek();

    }

    public int Top()
    {
        return st.Peek();

    }

    public int GetMin()
    {
        return min;

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