import java.util.*;
public class SpecialStack extends Stack<Integer> {
	
	 Stack<Integer> auxilary = new Stack<>(); 
     
	   public void push(int x) 
	    { 
	        if(isEmpty() == true) 
	        { 
	            super.push(x); 
	            auxilary.push(x); 
	        } 
	        else
	        { 
	            super.push(x); 
	            int y = auxilary.pop(); 
	            auxilary.push(y); 
	            if(x < y) 
	                auxilary.push(x); 
	            else
	                auxilary.push(y); 
	        } 
	    } 
	  
	    public Integer pop() 
	    { 
	        int x = super.pop(); 
	        auxilary.pop(); 
	        return x; 
	    } 
	  
	  
	   public int getMin() 
	    { 
	        int x = auxilary.pop(); 
	        auxilary.push(x); 
	        return x; 
	    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SpecialStack s = new SpecialStack(); 
	        s.push(10); 
	        s.push(20);  
	        System.out.println(s.getMin()); 
	        s.push(5); 
	        System.out.println(s.getMin());
	}

}