import java.util.Stack;

// Time Complexity : O(1) for push, pop, top, getMin
// Space Complexity : On an average, asymtotically it will less that O(n) we only have one stack and we only push twice if value is less than min.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/* As we were using extra space for another stack, we could optimize using 1 stack and pushing pairs where the next minimun lies underneath the top min. 
 * PUSH: if the incoming value is less than the min, we push the min first so that we can track the min, and push the value as well.
 * POP: if the popped element is less than the min we update min to stack pop
 */

public class MinStackOptimized {
    Stack<Integer> stack;
    int min;

    public MinStackOptimized() {
        this.stack = new Stack<Integer>();
        this.min = Integer.MAX_VALUE;
        stack.push(min);
    }
    
    public void push(int val) {
        if(val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        int popped = stack.pop();
        if(popped <= min) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
