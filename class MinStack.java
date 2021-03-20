import java.io.*;
import java.util.*;
import java.awt.List;
class MinStack {
        Stack<Integer> s;
        Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        s= new Stack<>();
         minStack= new Stack<>();
        minStack.push(Integer.MAX_VALUE);
                
        
    }
    
    public void push(int x) {
        
        s.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }
    
    public void pop() {
        s.pop();
        minStack.pop();
    }
    
    public int top() {
        return s.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
}

public static void main(String[] args)
{

 MinStack obj = new MinStack();
 obj.push(x);
  obj.pop();
  int param_3 = obj.top();
  int param_4 = obj.getMin();
 }