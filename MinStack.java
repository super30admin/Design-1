import java.util.Stack;
class MinStack {

    /** initialize your data structure here. */
    private Stack<int[]> stack;
    private int min;
    public MinStack() {
        stack = new Stack<int[]>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (val < min){
            min = val;
        }
        stack.push(new int[] {val, min});
    }
    
    public int pop() {
        int poppedElement = -1;
        if (stack.size() > 0){
            poppedElement = stack.pop()[0];
            if (stack.size() == 0)
                min = Integer.MAX_VALUE;
            else
                min = stack.peek()[1];
        }
        return poppedElement;
    }
    
    public int top() {
        if (stack.size() > 0){
            return stack.peek()[0];
        } else {
            return -1;
        }
    }
    
    public int getMin() {
        return min;
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