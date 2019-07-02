class MinStack {
	int min = Integer.MAX_VALUE;
	Stack<Integer> s1;

    /** initialize your data structure here. */
    public MinStack() {
    	
    	//Trick : use two stacks
    	
        s1 = new Stack<Integer>();
      
    }
    
    public boolean isEmpty() {
    	
    	return s1.isEmpty();
    }
    

    
    public void push(int x) {
       
        if(x<=min)
        {
        	//You anyway push first element in stack 2 AND THEN PUSH ONLY SMALLER ELEMENTS INSIDE.
        	
        	s1.push(min);
            min = x;
        }
        s1.push(x);
    }
    
    public void pop() {
    	int popped = (int) s1.pop();
    	if(popped==min)
    	{
    		min = s1.pop();
    	}
        
    }
    
    public int top() {
       int top = (int) s1.peek();
       return top;
    }
    
    public int getMin() {
    	return min;
    	
    	
        
    }
    
  
}

