/*
   
Design Min-Stack
*/

//Time comlpexity - O(1) 
//space complexity - O(n) 
// Did this code successfully run on Leetcode : Yes
/*
Any problem you faced while coding this : None

*/

// Your code here along with comments explaining your approach

class MinStack {
    
  //initialize the stack Data Structure
 Stack<Integer> stack;
 int min;
  
  public MinStack() { 
    stack = new Stack<Integer>();
    min = Integer.MAX_VALUE;
  }
  
  
  public void push(int x) {
      
    //if the stack is emoty then push x but if it is not empty
    // then enter the minimum value from the new number and the number entered last  
    if(x <= min)
    {
        stack.push(min);
        min = x;
    }
    stack.push(x);
  }
  
  
  public void pop() {
      if(stack.pop() == min)
      {
          min = stack.pop();
      }
}
  
  
  public int top() {
      if(stack.size() > 0)
      {
          return stack.peek();
      }
      return -1;
  }
  
  
  public int getMin() {
      return min;
  }
}