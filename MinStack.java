// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// for min stack, I maintained two stacks.
// 1 - for normal push
//2 - to keep track of min value upto last push.
//For pop, I popped from both stacks to maintain the level consistency.

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
            minStack.push(val);
        }
        else{
            stack.push(val);
            int min = Math.min(val,minStack.peek());
            minStack.push(min);
        }

    }

    public void pop() {
        if(!stack.isEmpty()){
            int temp = stack.peek();
            stack.pop();

            minStack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        else{
            return stack.peek();
        }
    }

    public int getMin() {
        return minStack.peek();
    }
}



