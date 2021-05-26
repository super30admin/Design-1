// Time Complexity: O(1)
// Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: None

class MinStack {
    Stack<Integer> s ;
    Stack<Integer> minS;
    /** initialize your data structure here. */
    public MinStack() {
        s= new Stack<>(); 
        minS = new Stack<>();   
    }
    
    public void push(int x) {
        s.push(x);
        if(minS.isEmpty() || x <= minS.peek()){ //Insert into min stack if new element is smaller than top element
            minS.push(x);
        }
    }
    
    public void pop() {
        int x = s.pop();
        
        if(x == minS.peek()){ //Pop from min stack only if the minimum element at the top is removed from main stack
           minS.pop();
        }
    }
    
    public int top() {
        return s.peek();
        
    }
    
    public int getMin() {
        return minS.peek();
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
