// Time Complexity : O(1) --> push, pop, get_min, top
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */

    private Stack<Integer> stack; 
    private Stack<Integer> min_stack; 
    
    public MinStack() {
        stack = new Stack<Integer>();
        min_stack = new Stack<Integer>();
        
    }
    
    public void push(int val) {
        if(min_stack.isEmpty() || val<=min_stack.peek())
            min_stack.push(val);
        stack.push(val);
        
        System.out.println("value is pushed");
    }
    
    public void pop() {
        if(stack.peek().equals(min_stack.peek()))
            min_stack.pop();
        stack.pop();
        System.out.println("value is popped");
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return min_stack.peek();
        
    }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public static void main(String args[]) 
{
    MinStack obj = new MinStack();
    obj.push(10);
    obj.push(19);
    obj.push(7);
    obj.pop();
    int param_3 = obj.top();
    int param_4 = obj.getMin();
    System.out.println("Top value in stack "+param_3);
    System.out.println("minimum value in stack "+param_4);

}
}