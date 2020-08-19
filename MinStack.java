import java.util.*;

class MinStack {    
    Stack<Integer> st =new Stack<>();
    Stack<Integer> min_val =new Stack<>();
    
    
    public void push(int x) {
    if(min_val.empty() || x<=min_val.peek())
        min_val.push(x);
        
        st.push(x);
    }
    
    public void pop() {   
        if(st.peek().equals(min_val.peek()))
            min_val.pop();
        st.pop();
        }
    
    public int top() {
        
        return st.peek();
             }
    
    public int getMin() {
        return min_val.peek();     
    }


public static void main(String[] args){
    MinStack obj = new MinStack();
    obj.push(-2);
    obj.push(0);
    obj.push(-3);
    System.out.println("min value= "+ obj.getMin());

     obj.pop();
     System.out.println("top value= "+ obj.top());
     System.out.println("min value= "+ obj.getMin());

   
}
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */