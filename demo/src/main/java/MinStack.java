import java.util.Stack;

public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minst;
    int min;

    public MinStack() {
        this.min=Integer.MAX_VALUE;
        this.st=new Stack<>();
        this.minst=new Stack<>();
        this.minst.push(min);
    }
    
    public void push(int val) {
        min=Math.min(min,val);
        this.minst.push(min);
        this.st.push(val);
    }
    
    public void pop() {
        this.st.pop();
        this.minst.pop();
        this.min = this.minst.peek(); // Update min to the top of min stack
    }
    
    public int top() {
        return this.st.peek();
    }
    
    public int getMin() {
        return this.min;
    }

    public static void main(String[] args) {
        // You can write test cases or run your MinStack implementation here
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Min: " + minStack.getMin()); // Output: -3
        minStack.pop();
        System.out.println("Top: " + minStack.top());    // Output: 0
        System.out.println("Min: " + minStack.getMin()); // Output: -2
    }
}
