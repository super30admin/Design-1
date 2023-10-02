
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this :  Yes when I used if statement to check val with min
// code ran successfully  but submission failed.  When I used Math.min it worked fine

//Approach - Use 2 stacks and have a variable to track the minNumber.  Initially start the  minNumber with Integer.MAX_VALUE
// use Math.min function to calculate min and the value pushed into the stack, push that minNumber to minStack.  Whenever pop
// happens, pop an element from both mainStack and minStack and update the minNumber using minStack.peek function.
// Peek only happens on mainStack and getMin returns the minNumber value.

import java.util.Stack;

// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    int minNumber ;
    public MinStack() {
        //initialize mainStack and minStack;
        //initialize min with Integer.Max_value and push the same to minStack.
        mainStack = new Stack<>();
        minStack = new Stack<>();
        minNumber = Integer.MAX_VALUE;
        minStack.push(minNumber);

    }

    public void push(int val) {
        this.mainStack.push(val);
        //Calculate the minNumber using Math Class min function
        //Then push that number to min Stack
        minNumber = Math.min(val, minNumber);
        minStack.push(minNumber);
    }

    public void pop() {

        minStack.pop();
        mainStack.pop();
        minNumber = minStack.peek();


    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minNumber;
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}