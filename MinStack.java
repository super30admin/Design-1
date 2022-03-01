// Time Complexity : All operations are O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing


// Your code here along with comments explaining your approach

import java.util.*;
class Ele{
    int val;
    int min;
      public Ele(int val,int min){
          this.val=val;
          this.min=min;
      }
  }
class MinStack {
  int min=Integer.MAX_VALUE;
  Stack<Ele> s=new Stack<Ele>();
  public MinStack() {   
  }
  public void push(int val) {
      min=Math.min(val,min);
      s.push(new Ele(val,min));
  }
  public void pop() {
      Ele a=s.pop();
      if(a.val==a.min){
          if(s.size()>0)
              min=s.peek().min;
          else 
              min=Integer.MAX_VALUE;
      }
  }
  public boolean isEmpty(){
      if (s.size()>0)
        return true;
      else
        return false;
  }
  public int top() {
      return s.peek().val;
  }
  
  public int getMin() {
      return s.peek().min;
  }
}

/*
I have used a stack of class objects, 
where the class object has two fields: 
the value and the minimum element in the stack when the value was added.
*/