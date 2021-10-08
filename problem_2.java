// Time Complexity
// push - O(1)
// pop - O(1)
// top - O(1)
// getMin - O(1)
// Space Complexity - O(n)
// Code ran successfully on leetcode 
//But when I used Arraylist instead of array I got errors, I didn't know why my code didn't run. 




class MinStack {
    
    Stack<int[]> stack = new Stack();
    int min= (int)Math.pow(2,31);
    public MinStack() {
        
    }
    
    public void push(int val) { 
        int [] stackArray= new int[2];
     
        if(stack.isEmpty()){
            stackArray[0]=val;
            stackArray[1]=val;
            stack.push(stackArray);
            return;
        }
        stackArray[0]=val;
        stackArray[1]= Math.min(stack.peek()[1],val);
        stack.push(stackArray);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
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