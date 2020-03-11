/*
 Time Complexity : O(1) for all operations
 Space Complexity : O(n) where n is capacity of stack
 Did this code successfully run on Leetcode : N/A
 Any problem you faced while coding this : I was not sure whether we can use stack.top method
*/


class SplStack {

		Stack stack;
		Stack minValues;
		int capacity;

		SplStack(int size){
			stack = new Stack(size);
			stack.push(0);
			minValues = new Stack(size);
			minValues.push(Integer.MAX_INT);
			this.capacity = size;
		}

		public void push(int x){
			if(!this.isFull()){
				if(x < minValues.top()){
					minValues.push(x);
				} else{
					minValues.push(minValues.top());
				}
				stack.push(x);
			}
		}
		
		public int pop() {
			if(!this.isEmpty()){
				minValues.pop();
				stack.pop();
			}
			return -1;
		}
		
		public boolean isEmpty(){
			if(stack.size() == 1){
				return true;
			}
			return false;
		}

		public boolean isFull() {
			if(stack.size() == capacity+1){
				return true;
			}
			return false;
		}

		public int getMin() {
			return minValues.top();
		}

}