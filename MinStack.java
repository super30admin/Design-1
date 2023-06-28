// Time Complexity : Time complexity for all these operations would be O(1)
// Space Complexity : Space complexity would be O(1) for all these functions as the space is required for the stack 
// Did this code successfully run on Leetcode :Yes

// Any problem you faced while coding this :
// I had already solved this on leetcode so I remembered how to solve this
// problem
// ALso had to lookup time complexity of stack and syntax of stack

// Your code here along with comments explaining your approach

//Used one stack to store all the elements and same stack to keep track of the smallest element. 
//Point of using a stack instead of a integer variable is to keep track of the smallest element in case the current smallest element is removed.
//Smallest Element will only be inserted into the stk if that element is smaller than or equal to the current smallest element. It will also be removed when the original element is removed from the main stack

import java.util.Stack;

class MinStack {
    int min;
    Stack<Integer> stk;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stk = new Stack<>();
    }

    public void push(int val) {
        if (min >= val) {
            this.stk.push(min);
            this.min = val;
        }
        this.stk.push(val);
    }

    public void pop() {
        if (this.stk.pop() == min)
            this.min = this.stk.pop();
    }

    public int top() {
        return this.stk.peek();
    }

    public int getMin() {
        return this.min;
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
