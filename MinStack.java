// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Time Complexity for this approach will be O(1)
// But Space Complexity will be O(n)
import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack= new Stack<>();
        min= Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {
        stack.push(val);
        min= Math.min(min,val);
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min= minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
    public static void main(String[] args) {
        MinStack minimum = new MinStack();
        minimum.push(-2);
        minimum.push(0);
        minimum.push(-3);
        minimum.getMin(); // return -3
        System.out.println(minimum.getMin());
        minimum.pop();
        minimum.top();    // return 0
        minimum.getMin();

    }

}


