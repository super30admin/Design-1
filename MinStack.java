package design1;
//time complexity: 0(1)
//space complexity: 0(n)
import java.util.Stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int ele) {
        if(ele <= min){          
            stack.push(min);
            min = ele;
        }
        stack.push(ele);
    }

    public void pop() {
        if(stack.pop() == min) {
        	min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String args[]) {
    	MinStack stack = new MinStack();
    	stack.push(10);
    	stack.push(20);
    	stack.push(5);
    	stack.pop();
    	stack.push(5);
    	stack.push(2);
    	stack.push(2);
    	stack.push(15);
    	System.out.println("Top: "+stack.top());
    	System.out.println("Min: "+stack.getMin());
		
	}
}