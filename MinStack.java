import java.util.*;
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Here we are maintaining two stacks one for storing all elements and one for storing only minimum elements

*/


public class MinStack {
    int minValue; 
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    /** initialize your data structure here. */
    public MinStack() {

        minValue=Integer.MAX_VALUE;
        stack=new Stack<>();
        
        minStack=new Stack<>();
        //we are pushing a Integer.MAX_VALUE so that whatever element is pushed first becomes the min element
        minStack.push(minValue);
    }
    
    public void push(int x) {
    
        if(x<=minStack.peek())
        {
            minStack.add(x);
            minValue=x;
        }
        stack.add(x);
    }
    
    public void pop() {
        //if the item we are popping is the min element then we pop it from the stack and also from minstack
        //and make the top of the min stack as new min element
        if(stack.peek()==minValue)
        {
            minStack.pop();
            stack.pop();
            minValue=minStack.peek();
        }
        else stack.pop();
    }
    
    public int top() {
        
        return stack.peek();
    }
    
    public int getMin() {
        return minValue;
    }

    public static void main(String[] args)
    {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-1);
        System.out.println(obj.getMin());
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
        

    }
}
