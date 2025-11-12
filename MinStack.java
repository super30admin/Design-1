import java.util.Stack;

class MinStack {
    private Stack<Integer> a;
    private Stack<Integer> b;


    public MinStack() {
        a=new Stack<Integer>();
        b=new Stack<Integer>();
    }

    public void push(int val) {
        a.push(val);
        if(b.isEmpty()||val<= b.peek()){
            b.push(val);
        }
    }

    public void pop() {
        if( a.peek().equals(b.peek())){
            b.pop();
        }
        a.pop();
    }

    public int top() {
        return a.peek();

    }

    public int getMin() {
        return b.peek();

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