//Reference leetcode 

import java.util.Stack;

 class SpecialStack {
	Stack<Integer> mainStack = new Stack(); //main stack
	Stack<Integer> minStack = new Stack(); //keeping minimum element
	public final int CAPACITY = 100;
	int min = Integer.MAX_VALUE;
	
	
	//insert element into stack
	void push(int element) {
		System.out.println("inserting element in stack element="+element);
		
		//if stack is not full push element.
		if(!isFull()) mainStack.push(element);
		else return ;
		//if minimum stack is empty then push element into minstack
	  if(minStack.isEmpty()) {
			minStack.push(element);
			return;
		}else {
			//if element is less than min stack the push element in min stack
			if(element<=minStack.peek()) {
				minStack.push(element);
			}
		}
	
		
	}
	
	void  pop() {
		//deleting element from main stack
		int deletedElement = mainStack.pop();
		System.out.println("deleting top element in stack element="+deletedElement);
		//if deleted element contains in minstack then deleting it
		if(deletedElement ==minStack.peek() && !minStack.isEmpty()) {
			minStack.pop();	
		}
	}
	
	int getMin() {
		System.out.println("minimum value in stack is:"+minStack.peek());
		return minStack.peek();
	}
	
	boolean isEmpty() {
		return mainStack.isEmpty();
	}
	
	boolean isFull() {
		return mainStack.size()== CAPACITY-1;
	}

}

 class MainSpecialStack{
	 public static void main(String[] args) {
		SpecialStack stack = new SpecialStack();
		 stack.push(10);
		 stack.push(11);
		 stack.push(12);
		 stack.getMin();
		 stack.push(7);
		 stack.pop();
		 stack.getMin();
}
}