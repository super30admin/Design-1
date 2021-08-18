import java.util.Stack;

// Time Complexity : big O(1)
// Space Complexity :big O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
public class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;
    int min;
    //initialize variables in constructor
    public MinStack(){
        s=new Stack<>();
        min=Integer.MAX_VALUE;  
        minStack=new Stack<>();
        minStack.push(min); 
    }
    public void push(int val){
        
            s.push(val);
            min=Math.min(min, val);
            minStack.push(min);
        }
        
    public void pop(){
        s.pop();
        minStack.pop();
        min=minStack.peek();
    }
    public int top()
    {
        return s.peek();
    }
    public int getMin()
    {
        return min;
    }

}
