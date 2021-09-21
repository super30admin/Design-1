time complexity - O(1)
space complexity - O(n)
Run on Leetcode - Yes
Approach- took 2 stacks one is the normal stack used to store values and other one stores min values

import java.util.*;
class MinStack {
    
    /** initialize your data structure here. */
   Stack<Integer> stack = new Stack();
   Stack<Integer> minStack = new Stack();
    //if minstack is null which means there is no minimum number found yet or if the value we need to push is less than the 
   //top most element of the min stack then it is the minimum value uptill now so it gets pushed to the minstack else push to the original stack
    public void push(int val) {
        if(minStack.isEmpty() || val<=minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
    }
    //if the top most element element of the original stack is equal to the top most element of the minstack then top element of the minstack should be popped out
    public void pop() {
       if(stack.peek().equals(minStack.peek())){
           minStack.pop();
       }stack.pop();
    }
    //top element of the original stack
    public int top() {
        return stack.peek();
    }
    //top element of the minstack
    public int getMin() {
        return minStack.peek();
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