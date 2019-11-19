class MinStack {

    /** initialize your data structure here. */
    /*Algorithm:
        1. Implemented using a single stack, Initially the min is set to infinity and pushed into the the stack.
        2. While pushing a new element to the stack, compare it with the minimum value. If the element is less than the current min, push the earlier min and then update the min to new element value. Later on the element is pushed always without any condition
        3. While popping we check if the popped element is equal to the current min, If yes then we know that there is one element below it which was the prior min so we pop once again and update min to the popped element.
        
    Time Complexity: O(1)
    Space complexity: O(n)
    Whether solution ran on leetcode? Yes
    
    */
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        stack.push(min); 
    }
    
    public void push(int x) {
        if(x<=min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
        
    }
    
    public void pop() {
        if(min==stack.pop()){
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */