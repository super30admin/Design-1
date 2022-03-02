// time complexity for push,pop, and peek will be O(1)

import java.util.Stack;

public class MinStack {
	
	private Stack<Integer> st;
    private Stack<Integer> minst;
    
    private int min;

    public MinStack() {
        
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minst = new Stack <>();
        minst.push(min);
        
    }
    
    
    public void push(int val) {
 
        
        min = Math.min(min, val);
        st.push(val);
        minst.push(min);
        
    }
    
    public void pop() {
        
        st.pop();
        minst.pop();
        
        min = minst.peek();
        
    }
    
    public int top() {
        
        return st.peek();
        
    }
    
    public int getMin() {
        return min;
        
    }
    
    public static void main (String [] args) {
    	
    	MinStack minStack = new MinStack();
    	minStack.push(-2);
    	minStack.push(0);
    	minStack.push(-3);
    	minStack.getMin(); // return -3
    	minStack.pop();
    	minStack.top();    // return 0
    	minStack.getMin(); // return -2
    	
    }

}
