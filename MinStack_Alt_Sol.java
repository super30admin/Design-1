/* Leetcode Execution:  No Problem, all test case passed.*/

/** Time Complexity: All stack operations: O(1)
 * Space Complexity: O(n), as no auxiallry stack is used.
 */

/**
 * Push to Stack and update min accordingly. Point to Note: When Min is updated (at push operation), push min value to stack & then update min.
 * Pop from Stack: If popping value = min, update min by popping one more element from the stack.
 * Top: Standard stack peek operation
 * getMin: Stored in memory in variable named: "min"
 */

class MinStack {

  int min;
  Stack<Integer> stack;
  /** initialize your data structure here. */
  public MinStack() {
      this.min = Integer.MAX_VALUE;
      this.stack = new Stack<>();
  }
    
    public void push(int x) {
    if(stack.isEmpty()) {
        min = x;
      } else if (x <= min) {
        stack.push(min);
        min = x;
      }
      stack.push(x);
    }
    
    public void pop() {
        if(stack.pop() == min) {
            if (stack.isEmpty()) {  // Edge Case when Last element id being popped which is equal to min.
                min = Integer.MAX_VALUE;
            } else {
                min = stack.pop();
            }
        
      } 
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
