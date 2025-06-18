/* 
Time Complexity : 
add: O(1)
remove: O(1)
contains: O(1)

Space Complexity :
add: O(n)
remove: O(n)
contains: O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : 
Missing semi-colons and small syntax errors. Logic was correctly implemented without
issues.

*/

// Your code here along with comments explaining your approach

class MinStack {
    Stack<Integer> s;
    int min;

    /*
    Initializing the stack 's' and integer 'min'
     */
    public MinStack() { 
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    /*
    If the value to be pushed is equal to or smaller than the 'min' of the existing stack,
    then the 'min' is pushed into the stack followed by the value.
     */
    public void push(int val) {
        if (val <= min) {
            s.push(min);
            min = val;
        }
        s.push(val);
    }
    
    /*
    First, a value is popped from the stack and saved as 'popped'.
    If this popped value is equal to the 'min' value, then the next value is also popped
    and the 'min' is changed to the newly popped value.
     */
    public void pop() {
        int popped = s.pop();
        if (popped == min) {
            min = s.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}