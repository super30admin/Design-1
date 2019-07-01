import java.util.Stack;

class MinStack {
	int min = Integer.MAX_VALUE;
	Stack s1;
	Stack s2;

    /** initialize your data structure here. */
    public MinStack() {
    	
    	//Trick : use two stacks
    	
        s1 = new Stack();
        s2 = new Stack();
    }
    
    public void push(int x) {
        s1.push(x);
        if(x<min)
        {
        	//You anyway push first element in stack 2 AND THEN PUSH ONLY SMALLER ELEMENTS INSIDE.
        	min = x;
        	s2.push(min);
        }
    }
    
    public void pop() {
    	int pop = (int) s1.pop();
    	if(pop==min)
    	{
    	
    		s2.pop();
    	}
        
    }
    
    public int top() {
       int top = (int) s1.peek();
       return top;
    }
    
    public int getMin() {
    	int min = (int) s2.peek();
    	return min;
    	
    	
        
    }
    
    public static void main(String args[])
    {
    
    	 MinStack obj = new MinStack();
    	 obj.push(44);
    	 obj.push(22);
    	 obj.push(1);
    	 obj.push(-2);
    	 obj.push(4);
    	 obj.push(43);
    	 obj.push(-3);
    	 obj.pop();
    	 int param_3 = obj.top();
    	 int param_4 = obj.getMin();
    	 System.out.println(param_4);
    	 System.out.println(param_3);
    	
    }
}

