

import java.util.Stack;
/*
 * Complexity for all the operations is O(1)
 * as we are maintaining minstack with minimum values 
 * Space Complexity O(n) worst case all operations are pushed in minstack*/

public class minstack {

		Stack<Integer> stack;
		Stack<int[]> minstk;
	
	  public minstack() {
	        stack=new Stack();
	        minstk=new Stack();
	    }
	    
	    public void push(int x) {
	      if(minstk.isEmpty() || x<=minstk.peek()[0]) {
	    	  minstk.push(new int[] {x,1});
	      }else if(x==minstk.peek()[0]){
	    	  minstk.peek()[1]++;
	      }
	      
	      stack.push(x);
	    }
	    
	    public void pop() {
	        
	        if(stack.peek()==minstk.peek()[0] && minstk.peek()[1]>0) {
	        	minstk.peek()[1]--;
	        }
	        if(minstk.peek()[1]==0){
	        	minstk.pop();
	        }
	        
	        stack.pop();
	    }
	    
	    public int top() {
			return stack.peek();
	        
	    }
	    
	    public int getMin() {
			return minstk.peek()[0];
	
	    }
	    
	    public static void main(String args[]) {
	    	minstack obj = new minstack();
	    	obj.push(18);
	    	obj.push(12);
	    	obj.push(6);
	    	//obj.push(6);
	    	int minobj =obj.getMin();
	    	System.out.println(minobj);
	    	obj.pop();
	    	minobj =obj.getMin();
	    	System.out.println(minobj);
	    	
	    }
}
