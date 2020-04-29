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
  private Stack<int[]> stack = new Stack<>();
  
  public MinStack() { }
  
  
  public void push(int x) {
      
    //if the stack is emoty then push x but if it is not empty
    // then enter the minimum value from the new number and the number entered last  
    if (stack.isEmpty()) {
          stack.push(new int[]{x, x});
          return;
      }
      
      int currentMin = stack.peek()[1];
      stack.push(new int[]{x, Math.min(x, currentMin)});
  }
  
  
  public void pop() {
      stack.pop();
  }
  
  
  public int top() {
      return stack.peek()[0];
  }
  
  
  public int getMin() {
      return stack.peek()[1];
  }
}