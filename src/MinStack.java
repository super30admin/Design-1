// Time Complexity : each operation O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MinStack {
	final int MAX = 10000;
	
	Node[] nodes;
	int top;
	
	private class Node{
		int data;
		int minVal;
		
		public Node(int data, int min) {
			this.data = data;
			this.minVal = min;
		}
	}
	
    /** initialize your data structure here. */
    public MinStack() {
        this.nodes = new Node[MAX];
        this.top = -1;
    }
    
    public void push(int x) {
        if(top == MAX) {
        		System.out.println("Stack overflow");
        		return;
        }
        
        Node node;
        if(top == -1) {
        	//first element in the stack, min value is same as current value pushed
        		node = new Node(x, x);
        } else {
        		//calculate new min value by comparing current min and pushed value
        		int newMin = nodes[top].minVal > x ? x: nodes[top].minVal;
        		node = new Node(x, newMin);
        }
        
        nodes[++top] = node;
    }
    
    public void pop() {
        if(top == -1) {
        		System.out.println("Stack underflow");
        		return;
        } else
        {
        		Node topNode = nodes[top--];
        		System.out.println("Poped out element is " + topNode.data);
        }
    }
    
    public int top() {
    	 if(top == -1) {
     		System.out.println("Stack underflow");
     		return -1;
     } else
     {
     		Node topNode = nodes[top];
     		return topNode.data;
     } 
    }
    
    public int getMin() {
    	if(top == -1) {
     		System.out.println("Stack underflow");
     		return -1;
     } else
     {
     		Node topNode = nodes[top];
     		return topNode.minVal;
     } 
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */