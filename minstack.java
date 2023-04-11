// Time Complexity : O(1)
// Space Complexity : O(n) but on average, better than that since not all pushes will take space to track the older min values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : none

/*
Approach:
- Used the concept of tracking the older min values on the same stack so that
  the min variable always holds the latest min value.
- In case of push(), we push the current min onto the stack to "track" it if
  it is less than or equal to the incoming value and set the new min as the
  incoming value.
- In case of pop(), we pop twice if the top of stack is equal to min, and set
  the new min as the second popped element.
*/
import java.util.Stack;

class MinStack {

    Stack<Integer> s;
    int min;

    public MinStack() {
        s = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        // push twice to track older min value
        if (val <= min) {
            s.push(min);
            min = val;
        }
        s.push(val);
    }
    
    public void pop() {
        if (s.pop() == min) {
            // if top of stack is same as min, then pop
            // again to remove that and store as new min
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
