public class MinStackTwo  {
	//global min
      int min = Integer.MAX_VALUE;
      Stack<Integer> st = new Stack<>();
      Stack<Integer> minStack = new Stack<>();
     
	   public void push(int x) 
	    { 
	       st.push(x);
	       if(x<min) {
	    	   min =x;
	    	   
	       }
	       minStack.push(x);
	      
	    } 
	  
	   public void pop()
	    { 
	       int x = st.pop();
	        minStack.pop();
	        
	        if(!minStack.isEmpty()) {
	        	min = minStack.peek();
	        }else {
	        	min = Integer.MAX_VALUE;
	        }
	       
	    } 
	  
	    /* SpecialStack's member method to get minimum element from it. */
	    int getMin() 
	    { 
	        return min;
	    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 MinStackTwo s = new MinStackTwo(); 
	        s.push(10); 
	        s.push(20); 
	        s.push(30); 
	        System.out.println(s.getMin()); 
	        s.push(5); 
	        System.out.println(s.getMin());
	}

}

