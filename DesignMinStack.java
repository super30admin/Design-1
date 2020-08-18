class MinStack {
	
	private Stack<int[]> stack = new Stack<>();

	public MinStack(){

	}

	public void push(int x){
		if(stack.isEmpty()){
			stack.push(new int[]{x, x});
			return;
		}
		int current_min = stack.peek()[1];
		stack.push(new int[]{x, Math.min(x, current_min)});
	}

	public void pop() {
        stack.pop();
        
    }
    
    public int top() {
        return stack.peek()[0];
        
    }
    
    public int getMin() {
        return stack.peek()[1];
        
    }
}

// Time Complexity : O(1) for all operations.
// Space Complexity : O(n). 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach