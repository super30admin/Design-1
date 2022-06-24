// Time Complexity : O(1)
// Space Complexity : O(1)

import java.util.Stack;

public class MinStack {

	Stack<Integer> stack;
	Stack<Integer> minStack;
	
    public MinStack() {
    	
    	stack = new Stack();
    	minStack = new Stack();
        
    }

	public void push(int val) {

		stack.push(val);
		if (minStack.isEmpty())
			minStack.push(val);
		else {
			if (minStack.peek() >= val) {
				minStack.push(val);
			}
		}
	}

	public void pop() {
		if (!stack.isEmpty()) {
			Integer popEle = stack.pop();
			if (popEle == minStack.peek())
				minStack.pop();
		}

	}
    
    public int top() {
    	if(!stack.isEmpty())
    		return stack.peek();
    	return -1;
    }
    
    public int getMin() {
    	if(!stack.isEmpty())
    		return minStack.peek();
    	return -1;
        
    }
    
    public static void main(String[] args) {
    	MinStack obj = new MinStack();
    	int val = 4;
    	 obj.push(val);
    	 obj.push(-2);obj.push(0);obj.push(-3);
    	 int param_1 = obj.top();
    	 System.out.println(param_1);
    	 int param_2 = obj.getMin();
    	 System.out.println(param_2);
    	 obj.pop();
    	 int param_3 = obj.top();
    	 System.out.println(param_3);
    	 int param_4 = obj.getMin();
    	 System.out.println(param_4);
    	 
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