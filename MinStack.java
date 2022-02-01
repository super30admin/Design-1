// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

package Stack;

import java.util.ArrayList;
import java.util.List;

class MinStack {

    // Create 2 AL to keep track of Min variable
    private List<Integer> stack = new ArrayList();
    private List<Integer> minStack = new ArrayList();

    public MinStack() {

    }

    // if stack pushes smaller elememt; compare the value in minstack and push smaller value to minstack
    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.add(val);
        } else if (val <= minStack.get(minStack.size()-1)) {
            minStack.add(val);
        }

        stack.add(val);
    }

    // if stack removes smaller elememt; compare the value in minstack and pop smaller value from minstack if present
    public void pop() {
        int poppedValue = stack.remove(stack.size()-1);
        int minValue = minStack.get(minStack.size()-1);

        if (poppedValue == minValue) {
            minStack.remove(minStack.size()-1);
        }
    }

    public int top() {
        return stack.get(stack.size()-1);

    }

    public int getMin() {
        return minStack.get(minStack.size()-1);
    }
}