import java.util.Stack;
import java.util.HashMap;

//Problem-1
// Time Complexity 
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :



//Problem-2
//Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MinStack {
    private int min;
    private Stack<Integer> minStack;
    

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        
    }
    
    public void push(int x) {
        if(x <= min){
            minStack.push(min);
            min = x;
        }
        minStack.add(x);
        
    }
    
    public void pop() {
        int popped = minStack.pop();
        if(popped == min){
            min = minStack.pop();
        }
        
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

