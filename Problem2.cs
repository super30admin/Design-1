public class MinStack {
    Stack S;
    Int32 min;
    /** initialize your data structure here. */
    public MinStack() {
        S = new Stack();
        min=  int.MaxValue;
    }
    
    public void Push(int val) {
        if(val <= min){
            S.Push(min);
            min = val;
        }
        S.Push(val);
    }
    
    public void Pop() {
        int top = Convert.ToInt32(S.Pop());
        if(top == min){
            min =  Convert.ToInt32(S.Pop());
        }
    }
    
    public int Top() {
        return  Convert.ToInt32(S.Peek());
    }
    
    public int GetMin() {
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