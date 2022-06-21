// Time Complexity : O(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.io.*;
import java.util.*;
class MinStack {
	Stack<Node> s;
	
	class Node{
		int val;
		int min;
		public Node(int val,int min){
			this.val=val;
			this.min=min;
			
		}
		
	}

	public MinStack() {
		this.s=new Stack<Node>();
	}
	public void push(int x) {
		if(s.isEmpty()){
			this.s.push(new Node(x,x));
		}else{
			int min=Math.min(this.s.peek().min,x);
			this.s.push(new Node(x,min));
		}	
	}
	public int pop() {
	
			return this.s.pop().val;
	}
	public int top() {
		
			return this.s.peek().val;
	}
	public int getMin() {
		
			return this.s.peek().min;	
	}
}




