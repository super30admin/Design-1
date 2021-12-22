// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : a little but was able to figure out,
//                  edge cases were issues but got resolved by using two stacks

import java.util.*;

class MinStack {

    Stack<Integer> fullStack;
    Stack<Integer> minStack;

    public MinStack()
    {
        this.fullStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();

    }

    public void push(int val) {
        if( this.minStack.isEmpty() || val <= this.minStack.peek() )
        {
            this.minStack.push(val);
        }

        this.fullStack.push(val);

    }

    public void pop() {
        if(!this.fullStack.isEmpty() && !this.minStack.isEmpty())
        {
            int peek1 = this.fullStack.peek();
            int peek2 = this.minStack.peek();

        	if(peek1==peek2)
            {
                this.minStack.pop();
            }
            this.fullStack.pop();
        }

    }

    public int top() {
        return this.fullStack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }


}
