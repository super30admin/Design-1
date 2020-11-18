// Time Complexity : O (1) for all ops
// Space Complexity : O (n) as we have created new stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach
class MinStack {

    private Stack<Integer> s = new Stack<>(); // Stores all elements in this Stack
    private Stack<Integer> min = new Stack<>(); // Stores minimum element until parsed elements in this Stack
    
    
    public MinStack() { }
    
    
    public void push(int x) {
        
        if (min.isEmpty() || x <= min.peek())
            min.push(x);
        s.push(x);
        
    }
    
    
    public void pop() {
        if (s.peek().equals(min.peek()))
            min.pop();
        s.pop();
    }
    
    
    public int top() {
        return s.peek();
    }

    
    public int getMin() {
        return min.peek();
    }
}