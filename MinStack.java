// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


import java.util.Stack;

// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> stack;
    int minimum = Integer.MAX_VALUE;

    public MinStack() {
        stack= new Stack<Integer>();
    }

    public void push(int val) {
        if(val <= minimum){
            stack.push(minimum);
            minimum=val;
        }
        stack.push(val);

    }

    public void pop() {
        if(stack.pop() == minimum)
            minimum=stack.pop();
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minimum;
    }

    public static void main(String[] args) {
        MinStack minStack=new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}
