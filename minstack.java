// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach

class MinStack {

    Stack<Integer> s;
    int min;
    Stack<Integer> minStack;

    public MinStack() {
        s = new Stack<Integer>();
        min = Integer.MAX_VALUE;
        minStack = new Stack<Integer>();
        minStack.push(min);
    }

    public void push(int val) {
        min = Math.min(val,min);
        s.push(val);
        minStack.push(min);
    }

    public void pop() {
        s.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }
}