// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Solution 3
class MinStack {
    // We can use one stack and push min and val in same stack
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;

    public MinStack() {
        // Initialize both stacks and push value of min in minStack
        stack = new Stack<>();
    }

    public void push(int val) {
        // Push min and val in stack and update min after that if val is less than equal to min
        // When val is less than equl to min push old min and new val
        if(val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        // Pop val from stack. Update min with top most value and then pop
        if(min == stack.pop()){
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
