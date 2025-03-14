// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Implemeted it using two stacks and pushed on to minStack only if it's empty or val is smaller than or equal to the top


class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        }
    }

    public void pop() {
        if (st.isEmpty()) return;
        int popped = st.pop();
        if (popped == minSt.peek()) {
            minSt.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }

    public static void main(String[] args) {
        MinStack minSt = new MinStack();
        minSt.push(-4);
        minSt.push(0);
        minSt.push(-5);
        System.out.println("Minimum: " + minSt.getMin()); // Output: -5
        minSt.pop();
        System.out.println("Top: " + minSt.top()); // Output: 0
        System.out.println("Minimum: " + minSt.getMin()); // Output: -4
    }
}
