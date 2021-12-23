// Time Complexity :O(1)
// Space Complexity :O(n)	
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Runtime error, because i wasnt checking he end of stack.


// Your code here along with comments explaining your approach
//Create a stack.. create global minimum tracker. if the new element is less than minimum then push the current minimum set minimum to new element and push new element.
//while popping pop, if the element is equal to minumum spop it set the next peek element minumum and pop it as well.

class MinStack {
    
    Stack<Integer> myStack ;
    int minimum =Integer.MAX_VALUE; 

    public MinStack() {
        myStack = new Stack();
        
    }
    
    public void push(int val) {
    	
    	if(myStack.size()==0) {
    		minimum=val;
    		myStack.push(val);
    		return;
    	}else if(val<=minimum) {
    		myStack.push(minimum);
    		minimum=val;
    		myStack.push(val);
    	}else {
    		myStack.push(val);
    	}
        
    }
    
    public void pop() {
    	if(myStack.size()==0) {
    		return;
    	}

    	if(myStack.peek()==minimum) {
    		myStack.pop();
            if(myStack.size()!=0)
    		minimum=myStack.pop();
    	}else {
    		myStack.pop();
    	}
        
    }
    
    public int top() {
    	return myStack.peek();
        
    }
    
    public int getMin() {
    	
    	return minimum;
        
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