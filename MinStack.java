// Creating stack which stores the minimum as well as current value
//while pushing, we will check if if current value is less than or equal to minimum value then push min into stack and make minimum as current value and also push value
//while popping, if popped value is minimum then pop the minium value and keep in minimum variable
//time complexity : O(1) for all opertions

class MinStack {

    //define stack
    Stack<Integer> stack ;
    int min;

    public MinStack() {

        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;

    }
    
    public void push(int val) {
        // if current value is less than minimum value then push min into stack
        //and make minimum as current val
        if(val <= min)
        {
            stack.push(min)  ;
            min = val;
        }
        //also push current value into the stack
         stack.push(val);
         
        
    }
    
    public void pop() {
    
      // if popped value is minimum then pop the minium value and keep in minimum variable
      if(min == stack.pop())
      {
         min =stack.pop();  
      } 
      
    }
        
    
    
    public int top() {
        // to get the top of the stack
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