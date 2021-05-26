// Time Complexity : O(1)
// Space Complexity : O(N)
import java.util.Stack;

class ClassImplementationMinStack {
    private Stack<Integer> stack;
   private int min;
   /** initialize your data structure here. */
   public ClassImplementationMinStack() {
      stack= new Stack<>();
       min=Integer.MAX_VALUE;
   }
   
   public void push(int val) {
     
      if(val<= min){
         stack.push(min);
          min=val;
      } 
       stack.push(val);
   }
   
   public void pop() {
       int popped = stack.pop();
       if(popped== min){
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