// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach

class MinStack {
    //created the below static class for maintaining the current value at the top of stack with the previous min value, for easier retrieval
    static class Node {
        int currVal;
        int minVal;
        public Node(int currVal, int minVal) {
            this.currVal = currVal;
            this.minVal = minVal;
        }
    }
    //creating a basic stack with the Node type
    Stack<Node> stack;
    // initially we are setting the min value to the max of Integer obj
    int min = Integer.MAX_VALUE;
    public MinStack() {
        stack = new Stack<>();
    }
    // if stack is empty, then the initial value we are setting to min
    // if current value is lesser than or equal to min,
    // then we are creating the node with current value and current min,
    // then resetting the min then to current value
    // else just create a node with current value and prev min
    public void push(int val) {
        if(stack.isEmpty()) min = val;
        if(min >= val) {
            stack.push(new Node(val, min));
            min = val;
        } else {
            stack.push(new Node(val, min));
        }
    }
    // when popped, we set the min to prev min
    public void pop() {
        int popped = stack.pop();
        min = popped.minVal;
    }

    public int top() {
        return stack.peek().currVal;
    }

    public int getMin() {
        return min;
    }

}

