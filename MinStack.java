// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : during the pop , if we are popping the min then i faced the issue.


// Your code here along with comments explaining your approach

class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    
    public MinStack() {
    }
    
    public void push(int val) {
       if(val <= min)
       {
           //stacking the oldest min
           stack.push(min);
           min=val;
       }
        //stacking all values for peek
        stack.push(val);
    }
    
    public void pop() {
        //if top element is min and if we do pop, then the next value is the min
        if(stack.pop()==min){
            min=stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;        
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