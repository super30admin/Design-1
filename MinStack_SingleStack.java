//Time Complexity:O(1)
//Space Complexity:O(n)
//Solution accepted and submitted on Leetcode.

import java.util.Stack;

class MinStack{
    
    private Stack<Integer> stack;
    int min;

    public MinStack() {
    	stack = new Stack<>();
    	min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x <= min)
        {
        	stack.push(min);
            min = x;
        }
        stack.push(x);    
    }
    
    public void pop() {
    	int p = stack.pop();
        if(p == min)
        {
        	min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
