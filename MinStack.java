import java.util.Stack;



class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minSt.push(min);
    }
    
    public void push(int val) {
        min = Math.min(min,val);
        st.push(val);
        minSt.push(min);
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }







    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        
        minStack.push(5);
        System.out.println("Pushed: 5, Min: " + minStack.getMin());
        
        minStack.push(3);
        System.out.println("Pushed: 3, Min: " + minStack.getMin());
        
        minStack.push(7);
        System.out.println("Pushed: 7, Min: " + minStack.getMin());
        
        minStack.push(2);
        System.out.println("Pushed: 2, Min: " + minStack.getMin());
        
        System.out.println("Top element: " + minStack.top());
        
        minStack.pop();
        System.out.println("Popped, Min: " + minStack.getMin());
        
        minStack.pop();
        System.out.println("Popped, Min: " + minStack.getMin());
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


