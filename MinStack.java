import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    
    //we will use one stack to store elements as well as minimum
    private Stack<Integer> stack;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {

        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
        
    }
    
    public void push(int val) {

        //if new min found, insert old min first to keep track
        if(val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);

    }
    
    public void pop() {
        //if the element being popped was the minimum then we pop twice
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */