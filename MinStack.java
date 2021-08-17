// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : NO


import java.util.Arrays;

class MinStack {
    
    int top;
    int Max;
    int Min=Integer.MAX_VALUE;
    int[] arr= new int[30000];

    /** initialize your data structure here. */
    public MinStack() {
        this.top=-1;
        this.Max=30000;
        Arrays.fill(arr,Integer.MAX_VALUE);
    }
    
    public void push(int val) {
    	
    	if(top==Max-1)
        {
        	System.out.println("stack is full cannot push :"+ val);
        }
        else
        {
        	arr[++top]=val;
        }
    	if(val<Min)
    	{
    		this.Min=val;
    	}
        
    }
    
    public void pop() {
    	   if(top>0)
           {
            int temp= top;
           	int b = arr[top--];
               arr[temp]=Integer.MAX_VALUE;
               System.out.println("pop:"+b);
          	generateMin();
           }
    	   
    }
    
    public int top() {
    	 if(top<0)
         {
  		   System.out.println("stack is empty");
  		   return -1;
         }
         else 
         {	
        	return arr[top];
         }
    }
    
    public void generateMin()
    {
    	int newmin = Integer.MAX_VALUE;
    	for(int i=0;i<arr.length;i++)
    	{
    		if(newmin>arr[i])
    		{
    			newmin=arr[i];
    		}
    	}
    	this.Min=newmin;
    	
    }
    
    public int getMin() {
    	return Min;     
    }
    
}

/**
["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
[[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
[null,null,null,null,null,0,null,0,null,0,null,0]
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */