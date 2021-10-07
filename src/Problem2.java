// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack = new Stack<Integer>();
        min =   Integer.MAX_VALUE;
        stack.push(min);

    }

    public void push(int val) {
        min = Math.min(min,val);
        stack.push(val);
        stack.push(min);
    }

    public void pop() {
        stack.pop();
        int res = stack.pop();
        min = stack.peek();
    }

    public int top() {
        stack.pop();
        int res = stack.peek();
        stack.push(min);
        return res;
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