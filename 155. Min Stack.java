import java.util.Stack;
class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        this.st = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);
        
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        minStack.push(min);
        
    }
    
    public void pop() {
        st.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return min;
        
    }

    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin()); // return -3
        obj.pop();
        System.out.println(obj.top());    // return 0
        System.out.println(obj.getMin());;// return -2
    }
}

