//****DESIGN A MINSTACK****
//Time Complexity:o(1)
//Space Complexity:o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO
class MinStack {
    Stack<Integer> stack;
    int min;

    public MinStack() {
        min=Integer.MAX_VALUE;
        stack =new Stack<>();
        
    }
    
    public void push(int val) {
        if(val<=min)
        {
            stack.push(min);
            min=val;
        }
        stack.push(val);
        
    }
    
    public void pop() {
        if(min==stack.pop())
        {
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