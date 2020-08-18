// Time Complexity :  O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : not really

class MinStack {

    Stack<Integer> mStack;
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        mStack = new Stack<>();
    }
    
    public void push(int x) {
        if(x <= min) {
            mStack.push(min);
            min = x;
        }
        mStack.push(x);
    }
    
    public void pop() {
        if(mStack.isEmpty()) {
            return;
        }

        int popped = mStack.pop();
        if(popped == min) {
            min = mStack.pop();
        }
    }
    
    public int top() {
        return mStack.peek();
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