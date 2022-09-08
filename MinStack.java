// Time complexity is : O(1)

class MinStack {

    Stack<Integer> s;
    Stack<Integer> minStack;
    int min;
    
    public MinStack() {
        min= Integer.MAX_VALUE;
        s= new Stack<>();
        minStack = new Stack<>();
        minStack.push(min);
    }
    //PUSHING The values twice
	//pushing the new element and pushing the min
    public void push(int val) {
        min= Math.min(min,val);
        s.push(val);
        minStack.push(min);   
    }
	
	// popping twice 
    public void pop() {
        s.pop();
        minStack.pop();
        min=minStack.peek();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */