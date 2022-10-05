// Approach - maintain min variable alongside Stack, and 
// when you find a new min (or duplicate) push both old min and val to stack.
// When popping from stack if you are popping the current min, pop gain again and update the current min
public class MinStack {
    Stack<int> s;
    int min;
    public MinStack() {
        s = new Stack<int>();
        min = Int32.MaxValue;
    }
    
    //Time Complexity : O(1)
    //Space Complexity : O(1)
    public void Push(int val) {
        if(val <= min)
        {
            s.Push(min);
            min = val;
        }
        s.Push(val);
    }
    
    //Time Complexity : O(1)
    //Space Complexity : O(1)
    public void Pop() {
        int val = s.Pop();
        if(val == min){
            min = s.Pop();
        }
    }
    
    //Time Complexity : O(1)
    //Space Complexity : O(1)
    public int Top() {
        return s.Peek();
    }
    
    //Time Complexity : O(1)
    //Space Complexity : O(1)
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