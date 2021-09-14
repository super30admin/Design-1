// Time Complexity : O(1).. minimum is at top at any point of time
// Space Complexity : O(n).. storing mimimum in an additional stack, worst case will be n elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : while comparing peek values I mistakenly used "==" instead" of .equals which failed me a few test cases, on rechecking i could figure out the mistake
//



// Your code here along with comments explaining your approach
//I used another stack where I pushed the values only if new value is smaller than peek item, and while popping- only remove if peek values of bothe stacks are equal


class MinStack {
	
	Stack<Integer> stack;
	Stack<Integer> stackMin;
	
	public MinStack() {
       stack= new Stack<Integer>();
       stackMin= new Stack<Integer>();     
    }
    
    void push(int val) {
    	
    	if(stack.isEmpty()) {
    		stack.push(val);
    		stackMin.push(val);
    		}else if(!stack.isEmpty() && val <= stackMin.peek()) {
    			stack.push(val);
    			stackMin.push(val);
    			}else {
    				stack.push(val);
    			}
        
    	}
    
    void pop() {
    	
    	if(stack.isEmpty()) {
    		return;
    	}
        if(stack.peek().equals(stackMin.peek())) {
        	stack.pop();
        	stackMin.pop();
        }else {
        	stack.pop();
        }
    }
    
    int top() {
    	
       return stack.peek();
    }
    
    int getMin()   {
    
    	
    	return stackMin.peek();    	
    }
    
}
