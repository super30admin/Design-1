// Time Complexity : Push  - O(1), Pop - O(1) , Top - O(1), Min - O(1). So Total of O(1) Asymtotic
// Space Complexity : O(n) for storing elements in stack is all that is required.  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

import java.util.Stack;
class MinStack2 { //Initializing the stack to store elements
    int min = Integer.MAX_VALUE;
    Stack <Integer> st = new Stack<>();
   
    //Stack <Integer> minst = new Stack<>();
    
    
    /** initialize your data structure here. */
    public MinStack2() { ////Push in the stack infinity/max value which is initially the min of the stack when no other elements present
       st.push(min);
    }
    
    public void push(int x) { //Check if the element is smaller than/equal to the min element. If yes, push the previous min first then push the newly obtained min.
                              //If the element is not greater than the global min, Just Push the element and proceed
        if(x <=  min)
        {
            st.push(min);
            min = x;
        }
        st.push(x);
    }
    
    public void pop() { //Check if element popped is equal to the min element. If yes then pop the element below it as well and make it min
                        //If element popped is not equal to min, then just pop.
        if(st.pop() == min){
            min = st.pop();
        }
        
    }
    
    public int top() {  // Return the top of the stack
        return st.peek();
    }
    
    public int getMin() { //Return the top of the Min Stack or return the value in the global min variable.
        return min;
    }
}
// Class with main function
class Main
{
    public static void main(String[] args)
    {
    MinStack2 obj = new MinStack2();
    obj.push(30);
    obj.push(40);
    obj.push(5);
    obj.push(-2);
    obj.push(-1);
    obj.pop();
    int param_3 = obj.top();
    int param_4 = obj.getMin();
    System.out.println("Top of the stack - " + param_3);
    System.out.println("Min element - " + param_4);
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