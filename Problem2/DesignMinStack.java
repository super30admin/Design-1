package Problem2;
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;
public class DesignMinStack {
    static class MinStack {
        Stack<Integer> stk;
        Stack<Integer> minStk;
        public MinStack() {
            stk = new Stack<>();
            minStk = new Stack<>();
        }

        public void push(int val) {
            stk.push(val);

            if(minStk.isEmpty() || val <= minStk.peek()) {
                minStk.push(val);
            }
        }

        public void pop() {
            int val = stk.pop();
            if(!minStk.isEmpty() && minStk.peek() == val) {
                minStk.pop();
            }
        }

        public int top() {
            return stk.peek();
        }

        public int getMin() {
            return minStk.peek();
        }
    }

    public static void main(String[] args) {
        MinStack stk = new MinStack();
        stk.push(2);
        stk.push(3);
        stk.push(1);
        stk.push(-1);
        System.out.println("Minimum number in satck: " + stk.getMin());
        stk.pop();
        System.out.println("Minimum number in satck: " + stk.getMin());
    }
}
