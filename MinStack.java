// Time Complexity : O(1)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach.
class MinStack {
    private Stack<Integer> minstack;
    private int minimum;


    public MinStack() {
        minstack= new Stack();
        minimum=Integer.MAX_VALUE;
    }
    
    public void push(int x) {
         if(x<=minimum){
            minstack.push(minimum);
            minimum=x; 
        }
          minstack.push(x);
        
    }
    
    public void pop() {
         int popped=minstack.pop();
        
        if(popped==minimum){
              minimum=minstack.pop();
        }
    }
    
    public int top() {
        return minstack.peek();
    }
    
    public int getMin() {
         return minimum;
    }
}