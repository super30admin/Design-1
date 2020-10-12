// Time Complexity : O(n)
// Space Complexity : O(1) (Auxiliary Space)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : The code was accepted when I ran on the leetcode but couldn't submit.


class MinStack {

	static final int MAX = 10;
	int top;
	int stackArray[] = new int[MAX];
    /** initialize your data structure here. */
    public MinStack() {
        top = -1;
    }
    
    public void push(int x) {
    	stackArray[++top] = x;
    }
    
    public void pop() {
    	stackArray[top--] = Integer.MAX_VALUE;
    }
    
    public int top() {
        return stackArray[top];
    }
    
    public int getMin() {
    	int minElement = stackArray[0];
        for(int i = 1; i < stackArray.length; i++)
        	minElement = Math.min(minElement, stackArray[i]);
        return minElement;
    }

    public static void main(String[] args)
    {
    	MinStack minStack = new MinStack();
		
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		 // return -3
		minStack.pop();
		System.out.println(minStack.top());    // return 0
		System.out.println(minStack.getMin());// return -2
    }
}





