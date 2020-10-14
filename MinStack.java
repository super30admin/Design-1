package Day1;

import java.util.Stack;

class MinStack {

    // Time Complexity : O(1)
    // All functions will have time complexity O(1) because push, peek functions can be performed in O(1) time from stack s1. Pop function can be performed in O(1) time from stack S1 and S2 both. Getmin function can be performed in O(1) time from stack S2.
    // Space Complexity : O(n)
    // Stack s1 and s2 will hold all n elements in worst case scenarios, when every incoming element is lesser than all the previos values.
    
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    
    /** initialize your data structure here. */
    
    // Two stacks used for implementing min stack ds
    // Stack s1 stores all elements present in min stack ds
    // Stack s2 stores the least element inserted in min stack ds at a point of time
    // Stacl s1 and s2 elements have a one to one mapping
    Stack<Integer> s1;
    Stack<Integer> s2; 
     
    // constructor to initialize min stack ds 
    // here, both stacks initialized 
    // Max value pushed to stack s2 to enable Math.min operation for next incoming element.
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        s2.push(Integer.MAX_VALUE);
    }
    
    // Push an element to s1 everytime push method is called.
    // Compare top value in s2 to incoming elem and push lesser of those values to s2.
    public void push(int x) {
        s1.push(x);
        s2.push(Math.min(s2.peek(), x));
    }
    
    // Remove topmost element from s1 everytime pop method is called
    // Remove topmost element from s2 also since one to one mapping is maintained between both the stacks
    public void pop() {
        if (s1.isEmpty()) {
            System.out.println("Min Stack is empty. Cannot pop an element.");
            return;
        }
        s1.pop();
        s2.pop();
    }
    
    // Topmost element of min stack ds is topmost element in s1 
    public int top() {
        if (s1.isEmpty()) {
            System.out.println("Min Stack is empty. Cannot retrieve top element.");
        }
        return s1.peek();
    }
    
     // Minimum element of min stack ds is topmost element in s2 
    public int getMin() {
        if (s2.isEmpty()) {
            System.out.println("Min Stack is empty. Cannot retrieve minimum element.");
        }
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */