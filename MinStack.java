// Complexity:
// Time Complextiy: O(1) for all operations
// Space Complexity: O(n)


class MinStack {

    // main stack to keep track of elements
    Stack<Integer> s;
    // stack that keeps track of the element
    Stack<Integer> minStack;
    // min element to be returned
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        // push the min value initially to the minStack to avoid stackIsEmpty() exception
        minStack.push(min);
    }

    public void push(int x) {
        min = Math.min(min, x);
        // push the element to the main stack
        s.push(x);
        // push min element to min stack
        minStack.push(min);
    }

    public void pop() {
        s.pop();
        minStack.pop();
        // min is the top element in the minStack
        min = minStack.peek();
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
