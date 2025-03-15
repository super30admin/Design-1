// Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode:Yes
// Any problem you faced while coding this: I got the approach but to faced difficulty in coding it out 


// Your code here along with comments explaining your approach

import java.util.Stack;
public class MinStack {

   Stack<Integer>st; //Stack of values
   Stack<Integer>min_val; //Stack of minimum values
   int min; //Current min val

    public MinStack() {
        this.st = new Stack<Integer>();
        this.min_val = new Stack<Integer>();
        this.min = Integer.MAX_VALUE;
        min_val.push(min);   //Pushing the minimum value to avoid empty test case 
    }
    
    public void push(int val) {
      min = Math.min(val,min);
      st.push(val);
      min_val.push(min);
}
    
    public void pop() {
        st.pop();
        min_val.pop();
        min = min_val.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
public static void main(String[] args) {
    MinStack obj = new MinStack();
    int val = 4;
    obj.push(val);
    obj.push(2);
    obj.pop();
    int param_3 = obj.top();
    int param_4 = obj.getMin(); 
    System.out.println(param_3 +" "+param_4); 
}
 //Your MinStack object will be instantiated and called as such:
  
}

