// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MinStack {

        Stack<Integer> s;
        
        int min;
    
    public MinStack() {
        s= new Stack<>();
      
        min = Integer.MAX_VALUE;
        s.push(min);
    }
    
    public void push(int val) {
       if(val<=min){
           s.push(min);
           min=val;
       }
        s.push(val);
    }
    
    public void pop() {
       if(min==s.pop()){
           min=s.pop();
       }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}

MY APPROACH:

I used single stack for operation 
1. Whenever we push element we compare it with min and if val is less we should add previous min and then value in stack otherwise only value.
2. Now while popping if first pop element and check if it is minimum and if min=s.pop() then we will remove one more element, if not equal to minimum we will pop one only not twice.
