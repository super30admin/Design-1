// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
   
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        //Additional stack to store the Minimum values
        minStack = new Stack<Integer>();
    }
   
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }
   
    public void pop() {
        if(stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
   
    public int top() {
        return stack.peek();
    }
   
    public int getMin() {
        return minStack.peek();
    }
}

class MinStackMain { 
    public static void main(String args[]) 
    {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(3);
        obj.push(2);
        obj.push(4);
        System.out.println(obj.stack);
        System.out.println("\n Get Min: "+obj.getMin());
        obj.pop();
        obj.pop();

        System.out.println(obj.stack);
        System.out.println("\n Get Min: "+obj.getMin());
    } 
}


// OUTPUT
/*
[5, 3, 2, 4]

 Get Min: 2
[5, 3]

 Get Min: 3
 */