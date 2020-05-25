import java.util.Stack;

public class MinStack {
	Stack<Integer> minStack;
	int min = Integer.MAX_VALUE;
	
	 /** initialize your data structure here. */
    public MinStack() {
    	minStack = new Stack<>();
        
    }
    
    public void push(int x) {
    	if(x<=min) {
    		minStack.push(min);
    		min = x;
    		minStack.push(x);
    		
    	}
    	else
    		minStack.push(x);
        
    }
    
    public void pop() {
    	int temp = minStack.pop();
    	if(temp == min) {
    		
    		min = minStack.pop();
    	}
    	
        
    }
    
    public int top() {
    	return minStack.peek();
        
    }
    
    public int getMin() {
    	return min;
        
    }

}
