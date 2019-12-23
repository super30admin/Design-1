import java.util.*;

class MinStack {

    Stack<Pair> stack;
    
    class Pair{
        int value;
        int min;
        public Pair(int x, int m){
            value = x;
            min = m;
        }
    }    
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Pair>();
    }
    
    public void push(int x) {
        if(stack.size() > 0){
            Pair top = stack.peek();
            stack.push(new Pair(x, Math.min(x, top.min)));
        } else {
            stack.push(new Pair(x, x));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        Pair top = stack.peek();
        return top.min;
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