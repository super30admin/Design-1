class MinStack {

    /** initialize your data structure here. */

    Stack<int[]> stack = null;
    int min = Integer.MAX_VALUE;

    public MinStack() {

        stack = new Stack<>();
    }

    public void push(int val) {

        if(!stack.isEmpty()){
            min = Math.min(stack.peek()[1],val);
            int[] arr = {val,min};
            stack.push(arr);
        }
        else{
            min = val;
            int[] arr = {val,min};
            stack.push(arr);
        }

    }

    public void pop() {

        stack.pop();

    }

    public int top() {

        return stack.peek()[0];

    }

    public int getMin() {
        return stack.peek()[1];

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
