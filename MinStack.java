// Time Complexity : O(1)
// Space Complexity : O(N) Using two stack to solve the issue
// Did this code successfully run on Leetcode : Yes and ran on the editor
// Any problem you faced while coding this : No, (just ran into one error in (x <= minst.peek()) missed the = condition).

import java.util.Stack;

/**
 */
public class MinStack {
    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> minst = new Stack<Integer>();
    MinStack () {

    }

    public void push (int x) {
        if (minst.isEmpty() || x <= minst.peek()) {
            minst.push(x);
        }
        st.push(x);
    }

    public void pop () {
        if (st.isEmpty()) {
            return;
        }
        int value = st.pop();
        if (value == minst.peek()) {
            minst.pop();
        }
    }

    public int getMin() {
        if (minst.isEmpty()) {
            return -1;
        }
        return minst.peek();
    }

    public int top(){
        if (st.isEmpty()) {
            return -1;
        }
        return st.peek();
    }

    public static void main(String args[]) {

        MinStack ms = new MinStack();
        ms.push(11);
        ms.push(8);
        ms.push(3);
        ms.push(14);
        System.out.println("Min Value :" +ms.getMin());
        ms.pop();
        ms.pop();
        System.out.println("Min Value :" +ms.getMin());
        System.out.println("Top Value :" +ms.top());
        ms.push(5);
        ms.push(16);
        System.out.println("Min Value :" +ms.getMin());
        System.out.println("Top Value :" +ms.top());
        ms.pop();
        ms.push(4);
        ms.push(10);
        System.out.println("Min Value :" +ms.getMin());
        System.out.println("Top Value :" +ms.top());
        ms.pop();
    }
}
