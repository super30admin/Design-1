// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took and initial approach of maintaining only 2 minimums
// and that failed when there are 2 min elements with same value

// Your code here along with comments explaining your approach

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> mStack; // to keep track of minimum's
    int maxStackSize;

    public MinStack() {
        stack = new Stack<>();
        mStack = new Stack<>();
        maxStackSize = -1; // set maxStackSize as -1 to indicate user has not provided max stack size
    }

    public MinStack(int maxStackSize) {
        stack = new Stack<>();
        mStack = new Stack<>();
        this.maxStackSize = maxStackSize;
    }

    public void push(int val) {
        if(!isFull()){
            stack.push(val);
            //push to min stack even if the top of min stack is same as new value coming in,
            //this helps us to handle case even there are more than 1 element with same min value
            if(mStack.isEmpty() || val <= mStack.peek()){
                mStack.push(val);
            }
        }else{
            System.out.println("Stack is Full, cannot push " + val);
        }
    }

    public void pop() {
        //if the element being popped is a min element, it needs to be popped from min stack as well
        if(stack.peek().equals(mStack.peek())){
            mStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mStack.peek();
    }

    public boolean isFull(){
        if( maxStackSize == -1)
            return false;
        else if (stack.size() == maxStackSize)
              return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
//        MinStack minStack = new MinStack();
//        minStack.push(2);
//        minStack.push(0);
//        minStack.push(3);
//        minStack.push(0);
//        System.out.println("getMin : "+ minStack.getMin());
//        minStack.pop();
//        System.out.println("getMin : "+ minStack.getMin());
//        minStack.pop();
//        System.out.println("getMin : "+ minStack.getMin());
//        minStack.pop();
//        System.out.println("getMin : "+ minStack.getMin());

        MinStack minStackWithSize = new MinStack(2);
        minStackWithSize.push(2);
        minStackWithSize.push(0);
        minStackWithSize.push(8);
        System.out.println("Is stack full ? : " + minStackWithSize.isFull());
        minStackWithSize.pop();
        minStackWithSize.push(3);
        minStackWithSize.push(0);
        System.out.println("getMin : "+ minStackWithSize.getMin());
        minStackWithSize.pop();

    }
}