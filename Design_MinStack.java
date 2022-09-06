// Time Complexity : O(1) 
// Space Complexity : O(N) where N is number of values being pushed. 
//                    Worst case is that there is no pop
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, it took a lot of time to understand the question itself and figure out an approach.Initially planned to use BST but it gave O(logn) so experimented with Stack.

// Your code here along with comments explaining your approach

class MinStack {
    
    private Stack<int[]> stack = new Stack<>();
    
    public MinStack() { }
    
    
    public void push(int x) {
        
        /* If the stack is empty, then the min value
         * must just be the first value we add. */
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
            return;
        }
        
        int currentMin = stack.peek()[1];
        stack.push(new int[]{x, Math.min(x, currentMin)});
    }
    
    
    public void pop() {
        stack.pop();
    }
    
    
    public int top() {
        return stack.peek()[0];
    }
    
    
    public int getMin() {
        return stack.peek()[1];
    }
}
