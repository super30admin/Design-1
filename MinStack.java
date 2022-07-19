// Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I have doubts in solving this using stack and using push, pop.


// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> stack = new Stack();
    Stack<Integer> min_value = new Stack();



    public void push(int val) {
        if (min_value.isEmpty() || val <= min_value.peek()) {
            min_value.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.peek().equals(min_value.peek())) {
            min_value.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_value.peek();
    }
}
