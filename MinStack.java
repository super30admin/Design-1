// Time Complexity :O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.lang.Object;
import java.lang.*;
import java.util.Stack;
import java.io.*; 
import java.util.*; 

class CustomStack{
    
    int currentValue;
    int minValue;
    CustomStack prevStackItem;
    
    public CustomStack(int currentValue,int minValue){
        this.currentValue=currentValue;
        this.minValue=minValue;
    }
}

class MinStack {
    
    CustomStack currentStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(currentStack==null){
            currentStack = new CustomStack(x,x);
        }else{
            CustomStack customStack = new CustomStack(x,x<currentStack.minValue?x:currentStack.minValue);
            customStack.prevStackItem = currentStack;
            currentStack = customStack;
        }
    }
    
    public void pop() {
        if(currentStack!=null){
            CustomStack customStack = currentStack.prevStackItem;
            currentStack=customStack;
        }
    }
    
    public int top() {
        
        if(currentStack!=null)
            return currentStack.currentValue;
        else
            return 0;
    }
    
    public int getMin() {
        
        if(currentStack!=null)
            return currentStack.minValue;
        else
            return 0;
}
    
}
