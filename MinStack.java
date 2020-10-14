import java.util.Stack;

// Time Complexity :  O(1) for all operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this : No

//Min Stack using single stack


public class MinStack {

    Stack<Integer> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        //if new value is less than or equal to global min push the current min to the stack
        // and update the global min to new value
        if(x<=min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        int value = stack.pop();
        //check  if the pop value is equal to min,
        // if  it is same we update the min with new min
        if(value==min){
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
        System.out.println("Min : "+minStack.getMin());
        minStack.pop();
        System.out.println("Top "+minStack.top() );
        System.out.println("Min : "+minStack.getMin());

    }
}