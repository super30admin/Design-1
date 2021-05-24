class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s, minS;
    /**
     minS is a stack that holds all min values in descending order
     and the order in whichh they appear
     **/
    public MinStack() {
        s = new Stack<>();
        minS = new Stack<>();
    }

    public void push(int val) {
        s.push(val);
        //push value in minS only if it is lesser
        if(minS.isEmpty() || minS.peek() >= val) {
            minS.push(val);
        }
    }

    public void pop() {
        /**
         Need to remove value from minS in case the value popped from
         main stack is current min value
         **/
        if(s.peek() == minS.peek()) {
            minS.pop();
        }
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minS.peek();
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