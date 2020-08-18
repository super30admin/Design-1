/*import java.util.Stack;*/
/*
 * Complexity for all the operations is O(1)
 * as we are maintaining minstack with minimum values 
 * Space Complexity O(n) worst case all operations are pushed in minstack*/
/*
After class changes to code using one stack

Space complexity reduced to O(n) i worst case but in average case  O(n+m)
m = minimum elements being added 
/*
public class minstack {

		Stack<Integer> stack;
		//Stack<int[]> minstk;
		int minvalue;
	
	  public minstack() {
	        stack=new Stack();
	        minvalue=Integer.MAX_VALUE;
	      //  minstk=new Stack();
	    }
	    
	    public void push(int x) {
	    	
	    	
	    	
	    	if(x<=minvalue) {
	    		stack.push(minvalue);
	    		minvalue=x;
	    		stack.push(x);
	    	}else {
	    		stack.push(x);
	    	}
	    	//System.out.println(stack.peek());
	    	
	    //	stack.push(x);
	    }
	    
	    public void pop() {
	    	
	    	//System.out.println(minvalue);
	        if(stack.peek()==minvalue) {
	        	if(stack.isEmpty()) {
		    		System.out.println("Empty stack");
		    		return;
		    	}
	        	stack.pop();
	        	minvalue= stack.peek();
	        //	System.out.println(minvalue);
	        	
	        	stack.pop();
	        }else {
	        	if(stack.isEmpty()) {
		    		System.out.println("Empty stack");
		    		return;
		    	}
	        	stack.pop();
	        }
	        
	       
	    }
	    
	    public int top() {
	    	if(stack.isEmpty()) {
	    		System.out.println("Empty stack");
	    		return 0;
	    	}
			return stack.peek();
	    }
	    
	    public int getMin() {
			
	return minvalue;
	    }
	    
	    public static void main(String args[]) {
	    	minstack obj = new minstack();
	    	obj.push(7);
	    	//obj.push(7);
	    	obj.push(7);
	    	obj.push(6);
	    	obj.push(4);
	    	obj.push(8);
		/*
		 * int minobj1 =obj.getMin(); System.out.println(minobj1); obj.push(5); int
		 * minobj2 =obj.getMin(); System.out.println(minobj2); obj.push(7);*/
	    /*	obj.pop();
	    	obj.pop();
	    	obj.pop();
	    	obj.pop();
	    	obj.pop();
	    	int minobj3 =obj.getMin();
	    	System.out.println(minobj3);
	    	System.out.println(obj.top());
	    	
	    }
}*/
