// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()) {
            minStack.push(x);
        }
        else {
            if(minStack.peek() >= x) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int ele = stack.pop();
        if(ele == minStack.peek()) {
            minStack.pop();
        }

    }

    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        else {
            return stack.peek();
        }
    }

    public int getMin() {
        if(minStack.isEmpty()) {
            return -1;
        }
        else {
            return minStack.peek();
        }
    }
}
