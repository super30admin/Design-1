// Time Complexity :O(1)
// Space Complexity :O(n) n- number of elements stored in stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :-


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        minStack=new Stack<>(); // to store min 
        stack=new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x); 
        if(minStack.isEmpty() || minStack.peek() >= x)
        {
            minStack.push(x); // store the first element.store further elements only if there is a new min each time
        }
    }
    
    public void pop() {
   
       if(minStack.peek().equals(stack.peek()) ) // if stack's top element is the min in minstack's top then pop it from minstack
       { 
           minStack.pop();
       }
      stack.pop();
    }
    
    public int top() {
       return stack.peek(); 
    }
    
    public int getMin() {
       return  minStack.peek();
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