class MinStack {
    private int min;
    private Stack<Integer> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }

    public void push(int val) {
        if(val<= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        int val = stack.pop();

        if(val == min){
            min = stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String [] args){

        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(1);
        stack.push(14);
        stack.push(0);
        System.out.println("min is:" + stack.getMin());
        stack.pop();
        System.out.println("min is:" + stack.getMin());
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