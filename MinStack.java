// Time Complexity : Push  - O(1), Pop - O(1) , Top - O(1), Min - O(1). So Total of O(1) Asymtotic
// Space Complexity : O(n) for storing elements in stack and O(n) for storing min elements in stack. So total = O(2n). Asymtotically - O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

import java.util.Stack;
class MinStack { //Initializing two stacks. One to store the elements and one to store the min elements
    int min = Integer.MAX_VALUE;
    Stack <Integer> st = new Stack<>();
    Stack <Integer> minst = new Stack<>();
    
    
    /** initialize your data structure here. */
    public MinStack() { ////Push in the min stack infinity/max value which is initially the min of the stack when no other elements present
       minst.push(min);
    }
    
    public void push(int x) { //Check if the current element is smaller than the current global min, if yes replace global min by current element
                              //Then push the element in the stack and push the gloabl min in the min stack
        if(x <  min)
        {
            min = x;
        }
        st.push(x);
        minst.push(min);
    }
    
    public void pop() { //Pop the element from the stack. Also pop element from the minstack. Make the top of the minstack the new global min
        st.pop();
        minst.pop();
        min = minst.peek();
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
    MinStack obj = new MinStack();
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