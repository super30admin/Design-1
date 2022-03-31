import java.util.Stack;

/**
 * Time complexity of all operations is O(1)
 * Space complexity is O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */
public class MinStackImplUsingTwoStacks {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;

    public MinStackImplUsingTwoStacks() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {
        if(val <= min){
            min = val;
        }
        stack.push(val);
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStackImplUsingTwoStacks obj = new MinStackImplUsingTwoStacks();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println("Stack data : " + obj.stack);
        System.out.println("Min value : " + obj.getMin());
        obj.pop();
        System.out.println("Stack data after pop : " + obj.stack);
        System.out.println("Top value : " + obj.top());
        System.out.println("Min value : " + obj.getMin());
    }
}