#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this : No
#Time complexity : O(1)


class MinStack {
     
    Stack<Integer> stack = new Stack();
    Stack<Integer> min_vals = new Stack();
        
   /** initialize your data structure here. */
  
   public void push(int val) {
       if(min_vals.isEmpty() || val <=  min_vals.peek()){
       min_vals.push(val);
       }
       stack.push(val);
   }
   
   public void pop() {
       if ( min_vals.peek().equals(stack.peek())){
           min_vals.pop();
        }
           
       stack.pop();
       
   }
   
   public int top() {
       return stack.peek(); 
   }
   
   public int getMin() {
       return min_vals.peek();
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