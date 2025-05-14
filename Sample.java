// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, one concept on line 27 when we use .euqlas vs == there is a difference.


class MinStack {
    Stack<Integer> mStack;
    Stack<Integer> tempStack;

    public MinStack() {

        mStack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int val) {

        mStack.push(val);

        if(tempStack.isEmpty()||val <=tempStack.peek()){
            tempStack.push(val);
        }
    }

    public void pop() {
        if (mStack.peek().equals(tempStack.peek())) {
            tempStack.pop();
        }
        mStack.pop();
    }

    public int top() {
        return mStack.peek();
    }

    public int getMin() {
        return tempStack.peek();
    }
}
