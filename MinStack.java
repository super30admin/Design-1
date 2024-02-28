    // Time Complexity : O(1)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    // Your code here along with comments explaining your approach
    // I have used 2 stacks, with 1-1 mapping between the primary stack and the minStack, I have used the built in stack 
    // data structure to implement

import java.util.*;

    class MinStack {
        Stack<Integer> primaryStack;
        Stack<Integer> minStack;
        int min;

        public MinStack() {
            this.min = Integer.MAX_VALUE;
            this.primaryStack = new Stack<>();
            this.minStack = new Stack<>();
            this.minStack.push(min); 
        }
        
        public void push(int val) {
            min = Math.min(min, val);
            this.minStack.push(min);
            this.primaryStack.push(val);
        }
        
        public void pop() {
            this.primaryStack.pop();
            this.minStack.pop();
            min = minStack.peek();
        }
        
        public int top() {
            return this.primaryStack.peek();
        }
        
        public int getMin() {
            return this.minStack.peek();
        }

        public static void main(String[] args){
            MinStack obj = new MinStack();
            obj.push(23);
            obj.push(24);
            obj.push(11);
            obj.pop();
            obj.push(25);
            obj.push(10);
            obj.pop();
            
            int param_3 = obj.top();
            int param_4 = obj.getMin();
            System.out.println("Param_3 "+ param_3);
            System.out.println("Param_4 "+ param_4);
    }
    }