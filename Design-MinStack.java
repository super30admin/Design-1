// Time Complexity : O(1) for push, pop, top and getMin
// Space Complexity : O(1) for push, pop, top and getMin
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Nope

import java.util.*;

class MinStack {
    
    /**
    
        Thought Process:
        2 Stacks - 1 min stack and 1 normal stack
        
        Push -> push to ns and check if x < ms.peek() -> ms.push(x)
        Pop -> if ns.peek() == ms.peek() -> pop from both ns & ms else only ns
    
    **/

    Stack<Integer> ns;
    Stack<Integer> ms;
    
    /** initialize your data structure here. */
    public MinStack() {
        ns = new Stack<>();
        ms = new Stack<>();
    }
    
    public void push(int x) {
        ns.push(x);
        /** 
        Previously wrote x<ms.peek()
        Got stuck in empty stack exception at getMin() func
        
        for test case ["MinStack","push","push","push","getMin","pop","getMin"]
                        [[],[0],[1],[0],[],[],[]]
        
        **/
        if(ms.isEmpty() || x <= ms.peek()) ms.push(x);
    }
    
    public void pop() {
        int nsPopped = ns.pop();
        if(nsPopped == ms.peek()) ms.pop();
    }
    
    public int top() {
        return ns.peek();
    }
    
    public int getMin() {
        return ms.peek();
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
