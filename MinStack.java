//Time complexity: O(1) for push, peek, pop, top and getMin
//Space Complexity: O(2N) but asymptotically O(N)
//Space Complexity: O(N)
// Did this code successfully run on Leetcode : YES

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minStack = new Stack();
    /** initialize your data structure here. */
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x<=minStack.peek()){
            minStack.push(x);
        }
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();      
    }
    public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(5);
		ms.push(3);
		ms.push(10);
		System.out.println(ms.getMin());
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