// Time Complexity : O(1)
// Space Complexity : O(n) (where n is size of input)
// Did this code successfully run on Leetcode (155): Yes
// Any problem you faced while coding this : No

import java.util.Stack;

class MinStack {

    Stack<Node> st;
    int minEle;

    class Node {
        int value;
        int min;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<Node>();
    }

    public void push(int x) {
        Node newNode;
        if (st.isEmpty()) newNode = new Node(x, x);
        else {
            newNode = new Node(x, Math.min(x, st.peek().min));
        }
        st.push(newNode);
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().value;
    }

    public int getMin() {
        return st.peek().min;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }

}
