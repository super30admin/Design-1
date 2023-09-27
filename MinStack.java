// Time Complexity :O(1)
// Space Complexity :O(2n) which is O(n) only
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No



	class MinStack {

		private Stack<Integer> stack;
		private Stack<Integer> minStack; 
		private int min;
		    public MinStack() {
		        this.stack=new Stack<>();
		        this.minStack=new Stack<>();
		        this.min=Integer.MAX_VALUE;
		        this.minStack.push(min);
		    }
		    
		    public void push(int val) { //When pushing the value we are doing a check in minStack we are always inserting min value compared with coming value. 
		        min=Math.min(min,val);
		        stack.push(val);
		        minStack.push(min);

		    }
		    
		    public void pop() {
		        stack.pop();
		        minStack.pop();
		        this.min=minStack.peek();
		    }
		    
		    public int top() {
		        return stack.peek();
		    }
		    
		    public int getMin() {
		        return minStack.peek();
		    }
		}

		
