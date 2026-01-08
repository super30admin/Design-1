import java.util.Stack;

public class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;
    private static int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.minSt.push(this.min);
    }

    public void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        minSt.push(min);
    }

    public void pop() {
        int re = st.pop();
        minSt.pop();
        min = minSt.peek();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String args[]){
        MinStack ms = new MinStack();
        ms.push(10);
        ms.push(4);
        System.out.println(ms);

    }
}
