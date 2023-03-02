public class MinStack
{
    Stack<int> st;
    Stack<int> minSt;
    int min;

    public MinStack()
    {
        this.min = int.MaxValue;
        this.st = new Stack<int>();
        this.minSt = new Stack<int>();
        this.minSt.Push(this.min);
    }

    public void Push(int val)
    {
        this.min = Math.Min(min, val);
        this.st.Push(val);
        this.minSt.Push(min);

    }

    public void Pop()
    {
        this.st.Pop();
        this.minSt.Pop();
        min = this.minSt.Peek();
    }

    public int Top()
    {
        return this.st.Peek();
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