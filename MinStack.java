package MinStack;

import java.util.Stack;

public class MinStack {
	public static class minstack{
	Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min_val = Integer.MAX_VALUE;
/** initialize your data structure here. */
public minstack() {
    
    
    minStack.push(min_val);
}

public void push(int x) {
   if  (x < min_val)
   {
        min_val = x;    
   } 
    
        stack.push(x);
       // System.out.println(x +" pushed into the stack");
        minStack.push(min_val);
       //  System.out.println(min_val +" pushed into the Minstack");
        
    
}

public void pop() {
    stack.pop();
    minStack.pop();
    min_val = minStack.peek();//Change the min to new min 
    
    
}

public int top() {
    int top_val = stack.peek();
    return top_val;
    
}

public int getMin() {
    return min_val;
}
	
	}
	public static void main(String[] args) {
		
		minstack obj = new minstack(); 
	        obj.push(5); 
	        obj.push(9); 
	        obj.getMin(); 
	        obj.push(8); 
	        obj.push(10); 
	        obj.getMin(); 
	        obj.push(11);
	        obj.pop(); 
	        obj.getMin(); 
	        obj.pop(); 
	        obj.top();
	         
	    

	}

}
