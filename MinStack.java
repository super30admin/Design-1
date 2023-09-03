// Time Complexity : O(1) for all functions
// Space Complexity : O(n) where n is number of element inserted into stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially faced problem with push function deciding how to push so we don't lose minimum.


public class MinStack {
    Stack<Integer> stack;
    //Stack<Integer> minStack;
    int min;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {

        if(val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if(min == stack.pop()){
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
