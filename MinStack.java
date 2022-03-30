// Time Complexity : O(1) for push, pop, top and peek methods.
// Space Complexity : O(N) asymtotically for both stacks.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach
/*
Used the two stacks approach. One stack stores only the min values and other stack stores all values.
*/

class MinStack {

    int min;
    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    public MinStack() {
        min=Integer.MAX_VALUE;
        mainStack= new Stack<>();
        minStack= new Stack<>();
    }

    public void push(int val) {
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }
        mainStack.push(val);
    }

    public void pop() {
        if(minStack.peek().equals(mainStack.peek())){
            minStack.pop();
        }
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

