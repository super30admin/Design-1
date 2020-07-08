
public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  int min = Integer.MAX_VALUE;
	    Stack<Integer> st = new Stack<>();
	    

	    /** initialize your data structure here. */
	    public MinStack() {
	        
	    }
	    
	    public void push(int x) {
	        if(x <= min){
	            st.push(min);
	            min =x;
	        }
	        st.push(x);
	        
	    }
	    
	    public void pop() {
	        int popped = st.pop();
	        if(popped == min)
	            min = st.pop();
	        
	    }
	    
	    public int top() {
	        return st.peek();
	        
	    }
	    
	    public int getMin() {
	        return min;
	        
	    }
}
