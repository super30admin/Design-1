# Design-1

## Problem 1:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)



## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)


class MinStack {
        Stack<Integer> s;
        Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        s= new Stack<>();
         minStack= new Stack<>();
        minStack.push(Integer.MAX_VALUE);
                
        
    }
    
    public void push(int x) {
        
        s.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }
    
    public void pop() {
        s.pop();
        minStack.pop();
    }
    
    public int top() {
        return s.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
        
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
