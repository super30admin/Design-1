// Time Complexity : for every function the time complexity is O(1)
// Space Complexity : I have used ArrayList so space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: In my intiution, I have used ArrayList and one variable to track minimum value. On further comparisons, we can keep track of minimum value.

import java.util.ArrayList;
public class MinStack {

    ArrayList<Integer> minStack;
    int minimum_value;

    public MinStack() {
        minStack = new ArrayList<>();
        minimum_value = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (val <= minimum_value){
            minStack.add(minimum_value);
            minimum_value = val;
        }
        minStack.add(val);
    }
    
    public void pop() {
        if (!minStack.isEmpty()){
            if(minStack.remove(minStack.size()-1)==minimum_value){
                minimum_value = minStack.remove(minStack.size()-1);
            }
        }
    }
    
    public int top() {
            return minStack.get(minStack.size()-1);  
    }
    
    public int getMin() {
            return minimum_value;
    
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

