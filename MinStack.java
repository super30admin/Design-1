// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The basic idea is to use a single stack and initially the min is assumed to be infinity. When a value less the current minimum is identified,
// then push the previous minimum followed by the new value. And when popping, pop the top of the stack and the next element below it if the 
// popped value is currently the minimum, then the lastly popped element will be the new minimum

class MinStack {

	    Stack<Integer> st;
		int min;

	    public MinStack() {
	        st = new Stack<>();
            min = Integer.MAX_VALUE;
	    }
	    
	    public void push(int val) {
	        if(min>=val){
                st.push(min);
                min=val;
            }
            st.push(val);
	    }
	    
	    public void pop() {
	        if(st.pop() == min){
                min = st.pop();
            }
	    }
	    
	    public int top() {
	        return st.peek();
	    }
	    
	    public int getMin() {
	        return min;
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