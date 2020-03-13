// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.*;

class MyStack{
	Stack<Integer> s;
	Integer minElement;
	
	MyStack(){
		s = new Stack<Integer>();
	}
	
	void getMin() {
        if (s.isEmpty()) 
            System.out.println("Stack is empty"); 
        else
            System.out.println("Minimum Element in the stack is: " + minElement); 
	}
	
	void push(int val) {
		if(s.isEmpty()) {
			minElement = val;
			s.push(val);
			System.out.println("Element has been inserted");
			return;
		}
		
		if(val < minElement) {
			s.push(2*val - minElement);
			minElement = val;
		}
		else {
			s.push(val);
		}
		System.out.println("Element has been inserted");		
	}
	
	void pop() {
		if (s.isEmpty()) { 
	        System.out.println("Stack is empty"); 
            return; 
        } 
		
        System.out.print("Top Most Element Removed: "); 
        Integer top = s.pop(); 
		  
        if (top < minElement) { 
            System.out.println(minElement); 
            minElement = 2*minElement - top; 
        } 		  
        else {
            System.out.println(top);
        }
	}
	
	void peek() {
        if (s.isEmpty()) { 
            System.out.println("Stack is empty "); 
            return; 
        } 
  
        Integer top = s.peek(); // Top element. 
  
        System.out.print("Top Most Element is: "); 
  
        if (top < minElement) 
            System.out.println(minElement); 
        else
            System.out.println(top); 
	}
	
    public static void main(String[] args) 
    { 
        MyStack s = new MyStack(); 
        s.push(3); 
        s.push(5); 
        s.getMin(); 
        s.push(2); 
        s.push(1); 
        s.getMin(); 
        s.pop(); 
        s.getMin(); 
        s.pop(); 
        s.peek(); 
    } 

}