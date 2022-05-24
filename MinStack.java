import java.util.*;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {

    Stack<int[]> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val,val});
            return;
        }

        int currentMin = stack.peek()[1];
        stack.push(new int[]{val, Math.min(val,currentMin)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
