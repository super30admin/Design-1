// Time Complexity : O(1) for push, pop, top, getMin
// Space Complexity : O(N) but on average we are bringing down the space complexity by using one stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
import java.util.Stack;

public class MinStack1 {
    Stack<Integer> stack;
    int min;

    public MinStack1() {
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

        if(min == stack.pop()){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
