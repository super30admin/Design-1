import java.util.Stack;

class MinStack {
    Stack<Integer> st = new Stack<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (x<=min){
            st.push(min);
            min = x;
        }
        st.push(x);    
    }
    
    public void pop() {
        if(st.pop() == min){
            min=st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
		public static void main(String args[]) {
			MinStack minStack = new MinStack();
			minStack.push(-2);
			minStack.push(0);
			minStack.push(-3);
			minStack.getMin(); // --> Returns -3.
			minStack.pop();
			minStack.top(); // --> Returns 0.
			minStack.getMin(); // --> Returns -2.
		}

	}
