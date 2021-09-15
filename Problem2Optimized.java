class MinStack {

    Stack<Integer> stack = null;
    int min= Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack =  new Stack<Integer>();
        stack.push(min);
    }
    
    public void push(int val) {
        if(min>=val)
        {
         stack.push(min);
         min=val;
        }
        stack.push(val);
       
    }
    
    public void pop() {
        if(min==stack.pop())
        {
            min = stack.pop();
            
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

//time complexity :O(1);
//space complexity : O(n);
//Approach one stack
//Easy after today's class explanation
//ran successfully on leedcode
