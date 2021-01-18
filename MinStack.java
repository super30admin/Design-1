import java.util.Stack;

public class MinStack {
	
	    Stack<Integer> st;
	    Stack<Integer> minStack;

	    int min;
	    public MinStack() {
	        st = new Stack<>();
	        minStack = new Stack<>();
	        min = Integer.MAX_VALUE;
	        minStack.push(min);
	    }

	    public void push(int x) {
	        min = Math.min(min, x);
	        minStack.push(min);
	        st.push(x);
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
	} 
