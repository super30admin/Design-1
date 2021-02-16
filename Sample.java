import java.util.Stack;

// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack {
    
    private Stack<Integer> data;
    private Integer min;

    /** initialize your data structure here. */
    public MinStack() {
        
       data =new Stack<>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<=min)
        {
            data.push(min);
            min=x;
            data.push(x);
        }
        else
        {
            data.push(x);
        }
        
    }
    
    public void pop() {
        int popped=data.pop();
        if (popped==min)
        {
            min=data.pop();
            
        }
        
            
        
    }
    
    public int top() {
        int peek_int=data.peek();
        return peek_int;
        
    }
    
    public int getMin() {
        return min;
        
    }
}

public class Sample
{
	public static void main(String[] args)
	{
		MinStack s = new MinStack(); 
        s.push(3); 
        s.push(5); 
        s.getMin(); 
        s.push(2); 
        s.push(1); 
        s.getMin(); 
        s.pop(); 
        s.getMin(); 
        s.pop(); 
        s.top(); 
		
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