import java.util.Stack;

public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack(){
        this.min = Integer.MAX_VALUE;
        this.minSt = new Stack<>();
        this.st = new Stack<>();
        minSt.push(min);
    }

    public void push(int key){
        min = Math.min(min, key);
        st.push(key);
        minSt.push(min);
    }

    public void pop(){
        st.pop();
        minSt.pop();
        min = minSt.peek();
    }

    public int top(){
       return st.peek();
    }

    public int getMin(){
        return minSt.peek();
    }

    public static void main(String args[]){
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(1);
        minStack.push(7);
        System.out.println("Min in Stack:"+minStack.min);
        minStack.pop();
        minStack.pop();
        System.out.println("Min in Stack:"+minStack.min);
    }
}
