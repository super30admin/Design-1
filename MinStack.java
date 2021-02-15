  
// Time Complexity : O(1)
// Space Complexity : O(n) - additional space
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : I initially did this problem using LinkedList, so it was little easy using the next pointer. I had to append min element as well
 in this apporach, which was tricky at start*/


// Your code here along with comments explaining your approach

class MinStack {
    
    /** initialize your data structure here. */
    Stack<Integer> minStack;
    int min;
    public MinStack() {
       minStack = new Stack<>(); // using stack data structure here
       min = Integer.MAX_VALUE; // Initially min would be Max value of integer in java
    }
    
    public void push(int x) {
        // If pushed value is less than or equal to current min, we push both the min and x value
        if(x<=min){
            minStack.push(min);
            min=x;
        }
        //we push x anyway, but it will be the last step;
        minStack.push(x);
    }
    
    public void pop() {
        int popped = minStack.pop();
        // if popped value is equal to current min, we set min to previous min by popping again from the stack.
        if(min==popped){
            min = minStack.pop();
        }
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        // at any time, we are storing only the min value in the stack during push or pop
        return min;
    }
}
