import java.util.Stack;
// Time Complexity :
// push()     -> O(1)
// pop()      -> O(1)
// top()      -> O(1)
// getMin()   -> O(1)
//
// Space Complexity : O(n) for maintaining two stacks (st and minSt)
//
// Did this code successfully run on Leetcode : Yes
//
// Any problem you faced while coding this : Initially managing the previous min value correctly during pop required
// storing historical min values. Solved using a second stack (minSt).
//
// Your code here along with comments explaining your approach:
//
// Approach:
// - Use two stacks: one for all values (`st`) and another for tracking min values (`minSt`).
// - Track current min using a `min` variable.
// - When pushing a value, if it is <= current min, store the current min into `minSt`, and update `min`.
// - When popping, if the popped value equals `min`, restore previous min from `minSt`.
// - This ensures getMin() always returns current minimum in O(1) time.

class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        this.st = new Stack();
        this.minSt = new Stack();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        st.push(val);
        // If minSt is empty or val is less than or equal to current min, push to minSt
        if (minSt.isEmpty() || val <= min) {
            minSt.push(min);
            min = val;
        }

    }

    public void pop() {
        int temp = st.pop();
        // If the popped value is equal to current min, pop it from minSt too
        if (temp == min) {
            min = minSt.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(9);
        obj.push(4);
        obj.push(3);
        obj.push(8);
        obj.push(2);
        System.out.println("Min: " + obj.getMin());
        obj.pop();
        System.out.println("Top Element: " + obj.top());
        System.out.println("Current Min: " + obj.getMin());

        obj.pop();
        obj.pop();
        System.out.println("After popping two times, Min: " + obj.getMin());

    }
}
