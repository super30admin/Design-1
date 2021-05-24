// Time Complexity :O(1) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class MinStack {
    
    int min=Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    //push 
    public void push(int x) {
        if(x <= min){
           stack.push(min);
           min=x; 
        }
        stack.push(x);
    }
    //pop
    public void pop() {
        if(stack.pop()==min) min=stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
