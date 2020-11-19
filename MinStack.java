import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStack() {

    }

    public void push(int x) {
        if(min.isEmpty() || x<=min.peek()){
            min.push(x);
        }
        s.push(x);

    }

    public void pop() {
        if(s.peek().equals(min.peek())){
            min.pop();
        }
        s.pop();

    }

    public int top() {
        if(!s.isEmpty()){
            return s.peek();
        }
        return -1;


    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
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