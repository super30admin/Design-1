
// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leet code : yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> s; 
    int min;  
    public MinStack() {
        s = new Stack<>(); //Initialize the stack
        min = Integer.MAX_VALUE;  //Initialize  the min     
    }
    
    public void push(int val) {
        if(val<=min){ //if the val is less than min
         s.push(min); //  push the min value
          min = val; // update the min
    }
    s.push(val); //push the value
    }
    
    public void pop() {
         int top = s.pop(); // pop the top element in the stack
         if(top==min) // if the top element is minimum
         {
         min = s.pop(); // again pop the value and update the min
    }
}
    public int top() {
        return s.peek(); // first value in the stack
        
    }
    
    public int getMin() {
         return min; //get the min value
    }
}
