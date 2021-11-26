// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Min stack using two stacks
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {
        min = Math.min(min, val); // get new minimum
        stack.push(val);
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack().peek(); // update min
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

// Using single stack to avoid adding duplicate values
class MinStack {
    int min;
    Stack<Integer> stack;
    public MinStack() {
        stack= new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        // to handle duplicate values use equals
        if(val <= min){ // add both min and value such that we can keep track of all mins
            stack.push(min); // push old minimum
            min = val; // update minimum
        }
        stack.push(val);
    }

    public void pop() {
        int val = stack.pop();
        if(min == val){ // if we are poping minimum 
            min = stack.pop(); // update min to old minimum
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
