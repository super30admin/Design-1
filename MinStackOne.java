public class MinStackOne {
	
	   int min = Integer.MAX_VALUE;
	    Stack<Integer> st = new Stack<>();
	     
	     
		   public void push(int x) 
		    { 
		       if(x<min) {
		    	   st.push(min);
		    	   min =x;
		    	   
		       }
		       st.push(x);
		       
		    } 
		  
		   public void pop()
		    { 
		      int popped = st.pop();
		      if(popped==min) {
		    	  min = st.pop();
		      }
		       
		    } 
		  
		    /* SpecialStack's member method to get minimum element from it. */
		    int getMin() 
		    { 
		        return min;
		    } 


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStackOne s = new MinStackOne(); 
        s.push(10); 
        s.push(20); 
        s.push(30); 
        System.out.println(s.getMin()); 
        s.push(5); 
        System.out.println(s.getMin());

	}

}
