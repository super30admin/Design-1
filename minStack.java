// Time Complexity : O(1)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MinStack {

    //Create two stacks -> one for maintaining minimum elements 
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stack_min = new Stack<>();

    public MinStack() { }

    //If current element to be pushed is less than top of the min_stack -> that is, it is the minimum element
    public void push(int x) {
        stack.push(x);
        if (stack_min.isEmpty() || x <= stack_min.peek()) {
            stack_min.push(x);
        }
    }

    //To pop an element, pop form both stacks if they are equal.
    public void pop() {
        if (stack.peek().equals(stack_min.peek())) {
            stack_min.pop();
        }
        stack.pop();
    }

    //Retrieve the top of the stack
    public int top() {
        return stack.peek();
    }

    //Get the minimum element, which is the top of the min_stack
    public int getMin() {
        return stack_min.peek();
    }
}// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your app
