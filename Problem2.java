import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(1)
class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;
    
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
        min = Integer.MAX_VALUE; // set to infinity to handle the empty minSt
                                // for the pop to work properly for storing min value
        minSt.push(min);
    }
    
    public void push(int val) {
        st.push(val);
        min = Math.min(min, val);
        minSt.push(min);
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}

public class Problem2 {
    public static void main(String[] args) {
         MinStack obj = new MinStack();
         obj.push(1);
         obj.push(2);
         obj.pop();
         int param_3 = obj.top();
         int param_4 = obj.getMin(); 
         System.out.println(param_3 + " " + param_4); 
    }
}
