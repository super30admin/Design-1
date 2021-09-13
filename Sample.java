// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();


    /** initialize your data structure here. */
    public MinStack() {
        min = this.min;


    }

    public void push(int val) {
        if(val<=min){
            stack.push(min);
            min = val;
        }
        stack.push(val);

    }

    public void pop() {
        if(stack.pop() == min)
            min = stack.pop();

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


// Your code here along with comments explaining your approach
