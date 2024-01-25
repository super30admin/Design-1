// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes (I do not have premium account though.)
// Any problem you faced while coding this : Syntax issues. Struggling at the moment

// It is two stack approach. Maintainly two stacks - one for push and another one for min
// min stack only holds min values. It new value is less than then push. If it is duplicate then also push.

public class MinStack {
    private Stack<Integer> minstack;
    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new Stack();
        this.minstack = new Stack();
    }

    public void push(int val) {
        stack.push(val);
        if(val <= min){
            minstack.push(val);
            min = val;
        }
    }

    public void pop() {
        if(stack.empty()) return;

        int val = stack.pop(); // return integer value in this case - AutoBoxing/Unboxing
        if(val == min) {
            minstack.pop();
            min = !minstack.empty()?minstack.peek():Integer.MAX_VALUE; //though this is not required as we are performing operation on non-empty stack
        }
    }

    public int top() {
        if(stack.empty()) return -1;
        return stack.peek();
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