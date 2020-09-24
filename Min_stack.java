// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach: I wrote this code after the class.


class MinStack {
    Stack<Integer> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;

    }

    public void push(int x) {

        if(x <= min)
        {
            stack.push(min);
            min = x;
        }
        stack.push(x);

    }

    public void pop() {
        if(stack.pop() == min)
        {
            min = stack.pop();
        }

    }

    public int top() {
        if(stack.size() > 0){
            return stack.peek();
        }
        return -1;

    }

    public int getMin() {
        return min;

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
