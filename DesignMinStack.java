/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class MinStack {
    
    private Stack<int[]> stack = new Stack<>();
    
    public MinStack() { }
    
    
    public void push(int x) {
        
        /* If the stack is empty, then the min value
         * must just be the first value we add. */
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
            return;
        }
        
        int currentMin = stack.peek()[1];
        stack.push(new int[]{x, Math.min(x, currentMin)});
    }
    
    
    public void pop() {
        stack.pop();
    }
    
    
    public int top() {
        return stack.peek()[0];
    }
    
    
    public int getMin() {
        return stack.peek()[1];
    }
    
    public static void main(String args[]) 
    { 
        MinStack ob = new MinStack(); 
        ob.push(0);
        ob.push(10);
        ob.push(-3);
        ob.push(-7);
        System.out.println("Minimum element is : "+ob.getMin()); 
        ob.pop();
        ob.pop();
        System.out.println("Top element is : "+ob.top());
        System.out.println("Minimum element is : "+ob.getMin()); 
        
    } 
}

// Time complexity : O(1) for push(), pop(), top() and getMin() since we are having a track of the min element
// Space complexity : O(N) for stack