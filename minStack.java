
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
import java.util.Stack;
class MinStack {
    Stack<Integer>s;// holds every value
    Stack<Integer>minStack;
    int min; //track the min values only

    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
        min=Integer.MAX_VALUE;
        
    }
    
    public void push(int val) { 
         //pushing new val in to main and checking for minstack too if it less than  or equal to  the top value of minstack then push the val to minstack too
        if(val<=min){
            s.push(min);
            min=val;
        }
        s.push(val);
        
    }
    
    public void pop() {
        int removed=s.pop();// Remove the val from stack and if removed element  is equal to min val then again do the pop and make min=removed val
        if(removed == min)
        min=s.pop();
        
    }
    
    public int top() {
        return s.peek();// return the peek element of mainstack
        
    }
    
    public int getMin() {
        return min;// return the min element of minstack by using getMin
        
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