// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> s;
    Stack<Integer> minstack;
    int min;

    public MinStack() {
        s = new Stack<>();
        minstack = new Stack<>();
        min = Integer.MAX_VALUE;
        minstack.push(min);
    }

    public void push(int val) {
        if (val<min) {
            min = val;
        }
        s.push(val);
        minstack.push(min);
    }

    public void pop() {
        s.pop();
        minstack.pop();
        min = minstack.peek();
    }

    public int top() {
        return s.peek();
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