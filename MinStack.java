// Time Complexity : O(1)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach : 1 Stack approach

class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> main_stack;
    private int global_min;
    
    public MinStack() {
        main_stack=new Stack<Integer>();
        global_min=Integer.MAX_VALUE;
       // main_stack.push(global_min);        
        
    }
    
    public void push(int val) {
        if(global_min >= val){
            main_stack.push(global_min);
            main_stack.push(val);
            global_min=val;
        }
        else
          main_stack.push(val);     
        
    }
    
    public void pop() {
        if(global_min==top()){
            main_stack.pop();
            global_min=main_stack.pop();            
        }
       else
           main_stack.pop();
        
    }
    
    public int top() {
        return main_stack.peek();
        
    }
    
    public int getMin() {
        return global_min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
