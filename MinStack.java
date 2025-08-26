// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No problems.
// Approach: Maintains one main stack for values and tracks the minimum using an auxiliary mechanism.
//           Every push also stores the previous minimum, ensuring getMin() is O(1).0
//           The minimum is restored/updated whenever a pop removes the current minimum.

class MinStack {
    Stack<Integer> s;
    int min;

    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;        
    }
    
    public void push(int val) {
        if(val <= min) {
            s.push(min);
            min = val;
        }
        s.push(val);
    }
    
    public void pop() {
        int popped = s.pop();
        if(popped == min){
            min = s.pop();
        }
        
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
       return min;
    }
}