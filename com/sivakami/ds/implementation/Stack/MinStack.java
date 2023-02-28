package com.sivakami.ds.implementation.Stack;

/*		Time complexity - O(1)
		Space Complexity - O(N) where N is the size of the stack.			*/

public class MinStack {
	
    StackNode top; 
    StackNode minTop;
   
    static class StackNode { 
        int data; 
        StackNode next; 
  
        StackNode(int data) { 
            //Constructor here
            this.data = data;
            this.next = null;
        } 
    } 
    
	
    public boolean isEmpty() { 
        return top == null;
    } 
  
    public void push(int data) { 
        StackNode node = new StackNode(data);
        node.next = top;
        top = node;
        //check if newly added value is smaller than current min.
        if(minTop == null || (data <= minTop.data)) {
        	StackNode newMin = new StackNode(data);
        	newMin.next = minTop;
        	minTop = newMin;
        }
    } 
  
    public int pop() { 	 
	    if(isEmpty()){
	        System.out.println("Stack underflow");
	        return 0;
	    }
	    int data = top.data;
	    top = top.next;
	    
	    // check if popped value is the min value.
	    if(minTop != null && data == minTop.data) {
	    	minTop = minTop.next;
	    }
	   
	    return data;
    } 
  
    public int top() { 
        if(isEmpty()){
	        System.out.println("Stack empty");
	        return -1;
	    }
	    return top.data;
    }
    
    public int getMin() {
    	return (!isEmpty() && minTop != null) ? minTop.data : null;
    }
  
	//Driver code
    public static void main(String[] args) { 
        MinStack sll = new MinStack(); 
  
        sll.push(10); 
        sll.push(20); 
        System.out.println("Top element is " + sll.top()); 
        sll.push(30); 
        System.out.println(sll.pop() + " popped from stack"); 
        System.out.println("Top element is " + sll.top());      
        System.out.println(sll.pop() + " popped from stack");        
        System.out.println("Top element is " + sll.top()); 
        
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