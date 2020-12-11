public class MinStack {
    public Stack st= new Stack();
    public Stack Min = new Stack();
​
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void Push(int x) {
        
        if(Min.Count==0 || x<=(int)Min.Peek())
        {
            Min.Push(x);
        }
        st.Push(x);
        
    }
    
    public void Pop() {
    
        if((int)st.Peek()==(int)Min.Peek())
        {
            Min.Pop();
        }
        st.Pop();
        
        
    }
    
    public int Top() {
      return (int) st.Peek();
        
    }
    
    public int GetMin() {
        return (int)Min.Peek();
        
    }
}
​
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.Push(x);
 * obj.Pop();
 * int param_3 = obj.Top();
 * int param_4 = obj.GetMin();
 */
