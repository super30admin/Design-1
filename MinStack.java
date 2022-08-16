// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;
class MinStack {
Stack <Integer> s=new Stack <Integer>(); 
Stack <Integer> minEle=new Stack <Integer> (); // To keep track of min elements

    
    public void push(int val) {
     if(minEle.isEmpty() || val <= minEle.peek()){ // check whether min stack is empty or the value which needs to inserted is less than or equal to top of min stack
    	 minEle.push(val); //push the value inside the min stack
     }
        s.push(val); // push the value inside 1st stack
    }
    
    public void pop() {
       if(s.peek().equals(minEle.peek())){ // check whether 1st stack top is equal to min stack top value then
    	   minEle.pop();// pop from min stack
       }
        s.pop();//  pop from 1st stack
        
    }
    
    public int top() {
        return s.peek(); //returns top of stack
    }
    
    public int getMin() {
        return minEle.peek(); //returns top of min stack
    }

public static void main(String a[]) {
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
System.out.print(minStack.getMin()); // return -2
}
}