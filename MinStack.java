// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Used a two stack approach to retrive the minimum element in constant time.
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> auxilStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        auxilStack = new Stack<>();

    }

    public void push(int x) {
        stack.push(x);
        if(auxilStack.isEmpty()){
            auxilStack.push(x);
        }
        else{
            if (x > auxilStack.peek()){
                auxilStack.push(auxilStack.peek());
            }
            else{
                this.auxilStack.push(x);
            }
        }
    }

    public void pop() {
        this.stack.pop();
        this.auxilStack.pop();


    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.auxilStack.peek();
    }


}

