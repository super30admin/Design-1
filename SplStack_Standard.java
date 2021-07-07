// Time Complexity :
//      push() - O(1)
//      pop() - O(1)
//      top() - O(1)
//      getMin() - O(1)
//      
// Space Complexity :
//      overall - O(n)
//      push() - O(1)
//      pop() - N/A
//      top() - N/A
//      getMin() - N/A
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

class MinStk {
    public int data;
    public int minElm;
}


class SplStack_Standard {

    Stack<MinStk> stk; //we use only the standard stack implementation

    /** initialize your data structure here. */
    SplStack_Standard() {
        //instantiate the stack
        stk = new Stack<MinStk>();
    }
    
    public void push(int x) {
        //instantiate stack entry object
        MinStk sO1 = new MinStk();
        //assign x to the data
        sO1.data = x;
        
        //check for underflow
        //initial minimum value is the data itself
        if(stk.empty())
        {
            sO1.minElm = x;
            stk.push(sO1);
        }
        else
        {
            //compare previous minimum value and current data entry
            if(x <= getMin())
            {
                sO1.minElm = x;
                stk.push(sO1);
            }
            else
            {
                sO1.minElm = getMin();
                stk.push(sO1);
            }
        }
    }
    
    public void pop() {
        //check for stack underflow
        if(stk.empty())
        {
            System.out.println("Stack Underflow");
        }
        else
        {
            stk.pop();
        }
    }
    
    public int top() {
        //check for stack underflow
        if(stk.empty())
        {
            System.out.println("Stack Underflow");
            return 0;
        }
        else
        {
            return stk.peek().data;
        }
    }
    
    public int getMin() {
        //check for underflow
        if(stk.empty())
        {
            System.out.println("Stack Underflow");
            return 0;
        }
        else
        {
            //get the current time instant mimimum value
            return stk.peek().minElm;
        }
    }

    public static void main(String[] args) {
        SplStack splStack = new SplStack();
        splStack.push(-2);
        splStack.push(0);
        splStack.push(-3);
        System.out.println("Minimum Value = " + splStack.getMin());   //--> Returns -3.
        splStack.pop();
        System.out.println("Popped Item = " + splStack.top());     //--> Returns 0.
        System.out.println("Minimum Value = " + splStack.getMin());   //--> Returns -2.
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
