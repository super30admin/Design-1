class MinStack {

    Stack<Integer> minStack;
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        minStack.push(min);
    }

    public void push(int val) {
        if(val<= min){
            minStack.push(min);
            min = val;
        }
        minStack.push(val);
    }

    public void pop() {
        int curr = minStack.pop();
        if(curr == min){
            min = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return min;
    }
}