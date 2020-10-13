package Day1;

import java.util.Stack;

class MinStack {

    // Time Complexity : O(1)
    // All functions will have time complexity O(1) because they use stack DS for which push, pop and peek functions can be performed in O(1) time.
    // Space Complexity : O(n)
    // Since we are using two stacks to implement the given data structure, so space complexity will be O(n).
    
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    
    /** initialize your data structure here. */
    
    // Two stacks used for implementing min stack ds
    // Stack st stores all elements present in min stack ds
    // Stack minStTracker stores the least element inserted in min stack ds at a point of time
    Stack<Integer> st;
    Stack<Integer> minStTracker; 
     
    // constructor to initialize min stack ds 
    // here, both stacks initialized 
    public MinStack() {
        st = new Stack<>();
        minStTracker = new Stack<>();
    }
    
    // Push an element to st everytime push method is called
    // Push an element to minStTracker only when :
    // a) minStTracker is empty
    // b) incoming elem is lesser than the one at the top of minStTracker
    public void push(int x) {
        st.push(x);
        if (minStTracker.isEmpty() || minStTracker.peek() >= x) {
            minStTracker.push(x);
        }
    }
    
    // Remove topmost element from st everytime pop method is called
    // Remove topmost element from minStTracker only when:
    // Removed element from st is same as the topmost element in minStTracker
    public void pop() {
        if (st.isEmpty()) {
            System.out.println("Min Stack is empty. Cannot pop an element.");
            return;
        }
        int temp = st.pop();
        if (minStTracker.peek() == temp) {
            minStTracker.pop();
        }
    }
    
    // Topmost element of min stack ds is topmost element in st 
    public int top() {
        if (st.isEmpty()) {
            System.out.println("Min Stack is empty. Cannot retrieve top element.");
        }
        return st.peek();
    }
    
     // Minimum element of min stack ds is topmost element in minStTracker 
    public int getMin() {
        if (minStTracker.isEmpty()) {
            System.out.println("Min Stack is empty. Cannot retrieve minimum element.");
        }
        return minStTracker.peek();
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