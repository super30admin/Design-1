/**

Time Complexity : O(1)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class MinStack 
{
    
    private Stack<int[]> stack;
    

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) 
    {
        if(this.stack.isEmpty())
        {
            int data[] = new int[]{val,val};
            this.stack.push(data);
            return;
        }
        
        int top[] = this.stack.peek();
        int min = Math.min(val,top[1]);
        int data[] = new int[]{val,min};
        this.stack.push(data);
    }
    
    public void pop() 
    {
        this.stack.pop();
    }
    
    public int top() 
    {
        return this.stack.peek()[0];
    }
    
    public int getMin() 
    {
        return this.stack.peek()[1];
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