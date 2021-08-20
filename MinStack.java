// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :  YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach


import java.util.Stack;

class MinStack {  //creating two stacks sta and min
    Stack<Integer> sta = new Stack<>();
    Stack<Integer> min = new Stack<>();
    int minimum; //initialising a minimum variable

    /** initialize your data structure here. */
    public MinStack() { 
        minimum = Integer.MIN_VALUE; //assigning Integer.MIN_VALUE to minimum
        min.push(minimum); //push the minimum to min stack
    }

    public void push(int val) { //for pushing checking whether the sta is empty or the given value is less than or equal to top element of min 
        if(sta.empty() || val<=min.peek())
            min.push(val); //if true then push the val to min stack
        sta.push(val); //else push to sta stack
    }

    public void pop() { // for popping checking if the sta top element equals min stack top element
        if(sta.peek().equals(min.peek()))
            min.pop(); //if true then pop the min stack top element
        sta.pop(); //else pop the sta stack top element
    }

    public int top() { //just return the top of sta stack
        return sta.peek();
    }

    public int getMin() { //just return the top of min stack
        return min.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */