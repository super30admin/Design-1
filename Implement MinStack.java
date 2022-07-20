// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes (Couldn't understand the solution with O(1) Time complexity and O(1) space complexity(Source:Youtube)). That solution uses a formula, couldn't understand why only that formula should be used.)

import java.util.*;
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minVal;
    public MinStack() {
        // initialized two stacks. One is used as a primary stack and other as cache to get the minimum value of the stack.
        stack=new Stack<>();
        minVal=new Stack<>();
        
    }
    
    public void push(int val) {
        // Usually we push the data to the primary stack
        stack.push(val);
        // after pushing, we check if the other stack to store the minimum value is empty
        // if it's empty we will push the same data in primary stack to other stack.
        if(minVal.isEmpty()){
            minVal.push(val);
        }
        //After the push operation done in primary stack, will compare the current peak in primary with the current peek in the other stack(MinVal).
        // if the current peek in primary stack is less than thae current peek in the minValue stack, that peek element in primary data will also be pushed to the minValue stack.
        //Otherwise, the current peek value in the minValue stack is pushed again to that stack
        // in this way, we have all the minimum values anytime in the stack, by storing stored them in the minValue stack with the above mentioned condition.
        else if(minVal.peek()>val){
            minVal.push(val);
        }
        else{
            minVal.push(minVal.peek());
        }
    }
    
    public void pop() {
        // when we need to remove the peek element from the primary, we also remove the peek element from the minValue stack., Thus, we have current minimim value of the stack as the peek element in the minValue stack.
        stack.pop();
        minVal.pop();
    }
    
    public int top() {
        //to know the top element, we just return the peek in primary stack
       return stack.peek();
    }
    
    public int getMin() {
        // to get minimum value at anytime in the stack, we ust need to return peek of the minValue stack. Based, on the above mentioned logic.
        return minVal.peek();
    }
}
