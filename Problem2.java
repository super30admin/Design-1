// Time Complexity : Add = O(1), Remove = O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Didn't know the concept behind it. Learnt in leetcode before coding this


// Your code here along with comments explaining your approach

class MinStack {
    //using two stacks approach, one to store all values and another for only minimun values
    Stack<Integer> stack;
    Stack<Integer> minValueStack;

    public MinStack() {
        //initilize the stacks
        stack = new Stack<>();
        minValueStack = new Stack<>();
    }

    public void push(int val) {
        //push the value to min stack only if given value is less than the top value of min stack. Initial check to push if stack is empty
        if(minValueStack.isEmpty() || val <= minValueStack.peek()) {
            minValueStack.push(val);
        }
        //general stack push
        stack.push(val);
    }

    public void pop() {
        //pop from both stacks, from min stack only if top value of both stacks are same, this is to make sure minimam value is on top
        if(stack.peek().equals(minValueStack.peek())) {
            minValueStack.pop();
        }
        //normal stack pop
        stack.pop();
    }

    public int top() {
        //check top element
        return stack.peek();
    }

    public int getMin() {
        //get the minimam element
        return minValueStack.peek();
    }
}