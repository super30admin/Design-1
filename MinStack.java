import java.util.Arrays;

class MinStack {

    int top;
    int stack[];
    int min; //min element to store minimum value in the stack, checked each time an element is pushed on the stack
    
    /** initialize your data structure here. */
    public MinStack() {
        top =-1;
        min = Integer.MAX_VALUE; //max value assigned to the min, temporarily
        stack = new int[100];
    }
    
    public void push(int x) {
        if(top==stack.length-1)
        {
            resizeStack();//if max size of stack is reached, double the size of the stack
        }
        
            stack[++top] = x; //push the element
            min = Math.min(min,x);       //if element if less than current min, set the min as currently pushed element
    }
    
    public void pop() {
        if(top>-1)
        {
            if(stack[top--]==min)	//if element popped was min, then min should be reassigned to the minimum value of the remaining elements in the stack
            {
                min = findMin();
            }
            
        }
    }
    
    public int top() {
        
            return stack[top];
    }
    
    public int findMin()
    {
        int newMin = Integer.MAX_VALUE;
        for(int i=0;i<=top;i++)
            newMin = Math.min(newMin,stack[i]);
        return newMin;
    }
    
    public int getMin() {
        return min;
        
    }
    
     private void resizeStack() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }
    

    
    public static void main(String args[])
    {
    	MinStack obj = new MinStack();
    	obj.push(-2);
    	obj.push(0);
    	obj.push(-3);
    	System.out.println("Min is: " + obj.getMin());
    	obj.pop();
    	System.out.println("Top is: " + obj.top());
    	System.out.println("Min is: " + obj.getMin());	
    }
}

