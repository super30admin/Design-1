package minStack;

import java.util.Stack;

public class MinStack2 {
	Stack<Integer> s;
	int min=Integer.MAX_VALUE; //initialize min to the max value 
	
	MinStack2(){
	this.s= new Stack<>();	
	//this.s.push(min);	
	}
	
	
public void push(int key) {
	
	// if the top of stack is larger we would change the min else simply push
	
	if(this.min>=key) {
		this.s.push(min);
		this.s.push(key);
		this.min=key;
	}else {
		this.s.push(key);
	}	
	
	}

public void pop() {
	
	// if the top is equal to min, we need to reset the min to new min
	if(!this.s.isEmpty()&&this.s.peek()==this.min) {
		this.s.pop();
		this.min=s.peek();
		this.s.pop();
	}else {
		s.pop();
	}
}

public int top() {
	return this.s.peek();
	
}
public int getMin() {
	
	return this.min;
}
	

}
