// Time Complexity :O(1)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Did the code after Sowmya explained it class.


// Your code here along with comments explaining your approach
class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private int min;
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        int val = stack.pop();
        if(min == val){
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
