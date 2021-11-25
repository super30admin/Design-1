// Time Complexity : O(1)
// Space Complexity : O(1) on average case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: 
// Used a single stack along with minVal integer, to implement the MinStack

class MinStack {
    Stack<Integer> stack;
    int minVal;

    // Intialisation
    // minval intialised to Max value
    public MinStack() {
        this.stack = new Stack<>();
        this.minVal = Integer.MAX_VALUE;
    }

    // for pushing we check if the val is less than min val
    // we push the minval into the stack
    // assign min val as val
    // then push the val onto stack
    public void push(int val) {
        if (minVal >= val) {
            stack.push(minVal);
            minVal = val;
        }

        stack.push(val);
    }

    // for poping we pop the element from the stack
    // if the popped element is equal min stack
    // min val should be changed to top value
    // then pop the stack

    public void pop() {

        int popped = stack.pop();
        if (minVal == popped) {
            minVal = stack.peek();
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */