import java. util. *;

class MinStack {

    Stack<Integer> values;
    Stack<Integer> min;
    int minVal;
    /** initialize your data structure here. */
    public MinStack() {
        values = new Stack<Integer>();
        minVal = Integer.MAX_VALUE;
        min = new Stack<Integer>();
        min.push(minVal); 
    }
    
    public void push(int val) {
        values.push(val);
        minVal = Math.min(minVal, val);
        min.push(minVal);
    }
    
    public void pop() {
        values.pop();
        min.pop();
        minVal = min.peek(); // this refreshes the new minimum
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return minVal;
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