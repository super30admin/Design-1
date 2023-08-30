// Time Complexity : O(1) //Since all the functions add/remove and contains runs in O(1)
// Space Complexity : O(N) space for creating the stack
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

/**
 * Output:
 * Min in Stack : -3
 * Top in Stack : 0
 * Min in Stack : -2
 */


// Your code here along with comments explaining your approach
import java.util.Stack;
public class DesignMinStack {

    Stack<Integer> stack;
    int min;

    //constructor
    public DesignMinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    //push
    public void push(int val) {
        /**
         * Using same stack for min and Value
         * pushing previous min in the stack first and then changing the value of min if the min<val
         * and pushing val in the stack
         */
        if(val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    //pop
    public void pop() {
        /**
         * Stack.pop already returns the top element and if it is equal to min,
         * we update min with one more pop from stack
         */
        if(stack.pop() == min)
            min = stack.pop();

    }

    //top
    public int top() {
        return stack.peek();
    }

    //getMin
    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        DesignMinStack obj = new DesignMinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        int a = obj.getMin(); // return -3
        System.out.println("Min in Stack : " + a);
        obj.pop();
        int b = obj.top();    // return 0
        System.out.println("Top in Stack : " + b);
        int c = obj.getMin(); // return -2
        System.out.println("Min in Stack : " + c);

    }
}
