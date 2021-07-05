import java.util.*; 

class MinStack {
	
	private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public MinStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        stack1.push(-1);
        stack2.push(Integer.MAX_VALUE);
    }
    public void push(int x) {
        stack1.push(x);
        stack2.push(Math.min(x, stack2.peek()));
    }
    public void pop() {
        if (stack1.size() > 1) {
            stack1.pop();
            stack2.pop();
        }   
    }
     
    public int top() {
        return stack1.peek();
    }
     
    public int getMin() {
        return stack2.peek();
    }
  
    public static void main(String args[]) 
    { 
    	MinStack obj = new MinStack();
    	obj.push(6);
    	obj.push(-3);
    	obj.push(0);
    	obj.push(4);
    	obj.pop();
    	int param_3 = obj.top();
    	System.out.print(param_3 + "\n");
    	int param_4 = obj.getMin();
    	System.out.print(param_4 + "\n");
    } 
}
