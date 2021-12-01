/**
 Time Complexity: O(1)
 Space Complexity: O(n)

 Approach: here we push the min element in the current stack along with other elements
 so that when we pop the element which is current min we have old of next min which we added in the stack
 */
class MinStack {
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {
        if (val <= min) {
            minStack.push(min);
            min = val;
        }

        minStack.push(val);
    }

    public void pop() {
        int poppedVal = minStack.pop();

        if (poppedVal == min) {
            min = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
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