import java.util.Stack;

public class DesignMinStack {
	Stack<Integer> stack;
    Stack<Integer> minStack;
    Integer minimum;
    
    /** initialize your data structure here. */
    public DesignMinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minimum = Integer.MAX_VALUE;
        minStack.push(minimum);
    }
    
    public void push(int x) {
        minimum = Math.min(minimum,x);
        stack.push(x);
        minStack.push(minimum);
        
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        minimum = minStack.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimum;
    }
    
    public static void main(String[] args) {
    	DesignMinStack minStack = new DesignMinStack();
    	minStack.push(-2);
    	minStack.push(0);
    	minStack.push(-3);
    	int param_2 = minStack.getMin();; // return -3
    	minStack.pop();
    	int param_3 = minStack.top();     // return 0
    	int param_4 = minStack.getMin();  // return -2
    	System.out.println(param_2);
    	System.out.println(param_3);
    	System.out.println(param_4);
	}
    
}
