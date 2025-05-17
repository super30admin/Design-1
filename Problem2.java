// Time Complexity : O(1)
// Space Complexity : O(n) worst case
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MinStack{
        Stack<Integer>stack = new Stack();
        Stack<Integer>minStack = new Stack();
        
    
   public void push(int val) {
        stack.push(val);
         if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int temp = stack.pop();
        if(temp==minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
