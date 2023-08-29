// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// To implement MinStack with O(1), we have to maintain a min value in an integer after every operation. 
// Push: if given value <= min, push existing min, update min and then push original value
// Pop: because we pushed min value twice, we have to pop it twice.
// if popped value = min, pop again

class MinStack {
    java.util.Stack<Integer> mainStack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        mainStack = new java.util.Stack<Integer>();
    }
    
    public void push(int val) {
        if(val<=min) {
        mainStack.push(min);
        min = val;
        }
        mainStack.push(val);
    }
    
    public void pop() {
        if(mainStack.pop() == min) {
            min = mainStack.pop();
        }
    }
    
    public int top() {
        return mainStack.peek();
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