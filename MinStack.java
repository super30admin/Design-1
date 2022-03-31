import java.util.Stack;

/**
 * Time complexity of all operations is O(1)
 * Space complexity is O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */
public class MinStack {

    Stack<Integer> stack;
    int min;

    public MinStack(){
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Stack data : " + minStack.stack);
        System.out.println("Min value : " + minStack.getMin());
        minStack.pop();
        System.out.println("Stack data after pop : " + minStack.stack);
        System.out.println("Top value : " + minStack.top());
        System.out.println("Min value : " + minStack.getMin());
    }
}
