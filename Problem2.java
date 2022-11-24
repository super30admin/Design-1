import java.util.Stack;


// Time Complexity : O(1),  
// Space Complexity : O(n), 
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : NO
class MinStack {
    Stack<Integer>  stack;
    int min;
    public MinStack() {
        min=Integer.MAX_VALUE;
        stack=new Stack<>();
    }
    
    public void push(int val) {
        if(val<=min){
            stack.push(min);
            min=val;
        }
        stack.push(val);
    }
    
    public void pop() {
        int popped = stack.pop(); 
        if(popped==min){
            min=stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

public class Problem2{
    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(9);
        
    }
  }
