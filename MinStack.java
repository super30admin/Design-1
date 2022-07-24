// Time Complexity : for push, pop, top, and getMin O(1)
// Space Complexity : Two Stacks O(N+N)=> O(2N) => O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    Implemented SplStack using two Stacks, Stack1 stores the values and Stack2 stores the minimum values.
    In the question it is mentioned that the Stack would be Non-Empty, So I am ignoring checking underflow
    exception. While pushing the element to Stack1, I will directly push to Stack1 but for Stack2 I will check
    whether the Stack2 peek element greater than or equal to the newly inserted value in Stack1. If the
    condition is satisfied the element get push to Stack2(min stack). In the case of popping the element
    I have popped the element from Stack1, whereas for Stack2 I have checked a condition that whether removed
    value from Stack1 is same as the peek element of Stack2, if yes then the value gets popped. Otherwise the
    minimum element would be kept in the Stack2.
 */



class MinStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MinStack() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
        this.stack2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        this.stack1.push(val);
        if(val<=this.stack2.peek()){
            this.stack2.push(val);
        }
    }

    public void pop() {
        int val = this.stack1.pop();
        if(val == this.stack2.peek()){
            this.stack2.pop();
        }
    }

    public int top() {
        return this.stack1.peek();
    }

    public int getMin() {
        return this.stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */