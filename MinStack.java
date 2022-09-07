// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MinStack {

    int min;

    Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;

    }

    public void push(int val) {
        if(val <= min) {
            minStack.push(min);
            min = val;
        }
        minStack.push(val);
    }

    public void pop() {
        if(minStack.pop() == min) {
            min = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
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