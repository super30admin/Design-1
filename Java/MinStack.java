// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/*
Using only one stack and comparing the input value to the minimum and if val less than min, then push min into the stack and update min and push the original input val also into the stack.
Else you just push the input val into the stack.
while popping compare the value to the min and if equal, pop it twice nad update the min to the previous min or else just pops the top of the stack.
min is getting updated timely, so we can just return min for getMin().
* */

class MinStack {
    Stack<Integer> stack;
    int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        int popVal = stack.pop();
        if (popVal == min) {
            min = stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
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