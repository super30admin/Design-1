import java.util.Stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stackMin;

    public MinStack() {
        stackMin = new Stack<>();
    }
    
    public void push(int val) {
        if(val <= min){
            stackMin.push(min);
            min = val;
        }
         stackMin.push(val);
    }
    
    public void pop() {
        int topElement = stackMin.pop();
        if(topElement == min){
            min = stackMin.pop();
        }
    }
    
    public int top() {
        return stackMin.peek();
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