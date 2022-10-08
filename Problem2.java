import java.util.*;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

public class Problem2 {
    static class MinStack {

        Stack<Integer> stack;
        int min = Integer.MAX_VALUE;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (val <= min) {
                stack.push(min);
                min = val;
            }
            stack.push(val);
        }

        public void pop() {
            int val = stack.pop();
            if (val == min) {
                min = stack.pop();
            }
        }

        public int top() {
            System.out.println(stack.get(stack.size() - 1));
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {
        String[] queries = new String[] { "MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin" };
        int[] values = new int[] { 0, -2, 0, -3, 0, 0, 0, 0 };
        MinStack stack = new MinStack();
        for (int i = 1; i < queries.length; i++) {
            // if (queries[i].equals("MyHashSet")) {
            // continue;
            // }
            if (queries[i].equals("push")) {
                stack.push(values[i]);
            }
            if (queries[i].equals("pop")) {
                stack.pop();
            }
            if (queries[i].equals("remove")) {
                int min = stack.getMin();
                System.out.print("MIN: " + min);
            }
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
}
