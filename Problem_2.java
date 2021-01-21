class MinStack {
    private int min;
    private Stack<Integer> stk;
    private Stack<Integer> minstk;
    /** initialize your data structure here. */
    public MinStack() {
      stk = new Stack<>(); 
      min = Integer.MAX_VALUE;
        
    }
    
    public void push(int x) {
      
      if(min >= x){ // takes care of duplicate
        stk.push(min);
        min = x;
        
        
      }
      stk.push(x);
        
    }
    
    public void pop() {
      if(!stk.isEmpty()){
        int popped = stk.pop();
        if(popped == min){
          min = stk.pop();
          
          
        }
      }
      else {
        System.out.println("Stack is empty!");
      }
      
    }
    
    public int top() {

        return stk.peek();
      
    }
    
    public int getMin() {
           return min;
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
