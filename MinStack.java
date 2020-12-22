// Time Complexity : The Time complexities for push, pop, top and getMin operations is O(1).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {

        stack = new Stack<>(); // stack which stores all the elements
        minStack = new Stack<>(); // stack which manages minimum elements

    }

    public void push(int x) {

        stack.push(x);

        //places the minimum element on the top of minStack
        if(minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        }

    }

    public void pop() {

        int top = stack.pop();

        //removes the top element on the minStack if it is the same element poped from the stack
        if(minStack.peek() == top){
            minStack.pop();
        }

    }

    public int top() {

        return stack.peek();

    }

    public int getMin() {

        return minStack.peek();

    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */