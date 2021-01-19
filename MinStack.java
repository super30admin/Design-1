/**
Time Complexity :
 - push() - O(1)
 - pop() - O(1)
 - peek() - O(1)
 - getMin - O(1)

Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this : None
*/

class MinStack {
    private Stack<Integer> minStack;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        /**
        Approach:
        - For every push, check if the element to be pushed is < or = to the min.
        - If so, first push the current min, reset the min to the new min, 
          then push the new element, which is the current min.
        - If the element is > than min, just push it.
        */

        if (x <= min) {
            minStack.push(min);
            min = x;
        }
        minStack.push(x);
    }
    
    public void pop() {
        /**
        Approach:
        - First check if the stack is empty.
        - If not, pop the top element.
        - Check if the top element is the min.
        - If it is, pop again.
        - We pop twice to make the top point to the correct element.
        */
        if (minStack.isEmpty()) {
            return;
        }
        int popped = minStack.pop();
        if (popped == min) {
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
