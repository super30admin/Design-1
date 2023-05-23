// Time Complexity : O(1)
// Space Complexity : O(n)
    //Where n is the size of the MinStack

// Did this code successfully run on Leetcode : 
    //Yes. Beats 100% of all LeetCode Java Submissions in terms of Time Complexity. But struggles a lot with Space Complexity, it only beats 5.25% of them.

// Any problem you faced while coding this : 
    //I was able to optimize the time taken, but not able to optimize the space required. 
    //I am basically using double the space, the value and minimum most number then are both being stored in the stack. How do I optimize it more?

// Your code here along with comments explaining your approach

    //While pushing a new value, I am checking if the new value is the new minimum or not,
        //If it is the new minimum, then mention this as the new minimum along with the new value in its node.
        //If it is not the new minimum, then mention the existing minimum along with the new value in its node.

class MinStack {

    StackNode top;

    public MinStack() {
        top = null;
    }
    
    public void push(int val) {
        StackNode temp = new StackNode(val);
        if (top==null)
        {
            temp.minimumNow = val;
        }
        else
        {
            int min = top.minimumNow;
            if(val<min)
            {
                temp.minimumNow = val;
            }
            else
            {
                temp.minimumNow = min;
            }
            temp.next = top;
        }
        top = temp;
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.value;
    }
    
    public int getMin() {
        return top.minimumNow;
    }
}

class StackNode 
{
    int value;
    int minimumNow;
    StackNode next;
    
    StackNode(int value)
    {
        this.value = value;
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