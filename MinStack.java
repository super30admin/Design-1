// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no problems faced
//Approach - used 2 stacks, one for storing input values, other for previous minimum values, used another variable called min for storing current value of min. For handling duplicates, we are using this min value and for duplicate or change of min we push it to minStack.

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack, minStack;
    int min;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        this.minStack.push(min);
    }

    public void push(int val) {
        if(min >= val) {    //push previous min first and update new min
            this.minStack.push(min);
            this.min = val;
        }
        this.stack.push(val);   //push value
    }

    public void pop() {
        if(this.stack.pop() == this.min) {  //if true deleting current minimum else element is poped anyways
            this.min = this.minStack.pop(); //update min by using previous min
        }
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(5);
        minStack.push(3);
        System.out.println("Current top: " + minStack.top());
        System.out.println("Current min: " + minStack.getMin());

        minStack.push(7);
        System.out.println("After pushing 7, min: " + minStack.getMin());

        minStack.pop();
        System.out.println("After popping top, current top: " + minStack.top());
        System.out.println("Current min: " + minStack.getMin());

        minStack.push(3);
        System.out.println("Current top: " + minStack.top());
        System.out.println("Current min: " + minStack.getMin());

        minStack.pop();
        System.out.println("After popping 3, current top: " + minStack.top());
        System.out.println("Current min: " + minStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */