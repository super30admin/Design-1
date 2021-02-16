// Time Complexity : O(1) as it is going to remain constant for push,pop,peek,getmin no matter what the element is
// Space Complexity :O(n) depends on the number of elements
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Was pretty 


// Your code here along with comments explaining your approach
// We are going to first insert infinity to the stack and create a variable min which is going to be initialised to infinity
//If we want to push an element , we are going to first always compare it to the min value and if the element to be inserted is less than or equal to min
//we are first going to push min to the stack and then assign the current element to min and then insert the element. This way we will not loose track of min
//when we are doing the pop operation.Whenever the element to be popped is equal to min , we will have to do 2 pop operations and assign the second element
//back to min.
class MinStack {
    
    private Stack<Integer> stack;
    private Integer min;
    /** initialize your data structure here. */
    

    public MinStack() {
        
        stack = new Stack<>();
    	//initilise the min to inifinity so that it is the first element being inserted in the stack.
        min = Integer.MAX_VALUE;
        
    }
    
    public void push(int x) {
    	//if the element being pushed is smaller that the min element then push min first and assign that to the variable min
        if(x<=min)
        {
            stack.push(min);
            min = x;
        }
        //pushing the element to stack
        stack.push(x);
        
    }
    
    public void pop() {
    	
    	//assign the popped element to a variable
        int popped = stack.pop();
        
        //if popped element is equal to min then pop again and assign the popped element to min.
        if(popped==min)
        {
            min = stack.pop(); 
        }
        
    }
    
    public int top() {
    	//return the top element using built in stack methods
        return stack.peek();
        
    }
    
    public int getMin() {
    	//return value assigned to min. We kept that updated through the push and pop method.
        return min;
        
    }
}