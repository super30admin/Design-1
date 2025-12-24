import java.util.Stack;

public class MinStack {

	 Stack<Integer> st;
	    int min=0;
	    /** initialize your data structure here. */
	    public MinStack() {
	        st=new Stack<>();
	        min=Integer.MAX_VALUE;
	    }
	    
	    public void push(int x) {
	        if (x<=min){
	            st.push(min);
	            min=x;
	        }
	        st.push(x);
	    }
	    
	    public void pop() {
	        int pop=st.pop();
	        if (min==pop)
	            min=st.pop();
	        
	    }
	    
	    public int top() {
	        return st.peek();
	    }
	    
	    public int getMin() {
	        return min;
	    }
	
}
