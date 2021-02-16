// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> stack; // declaring Stack 
    int min = Integer.MAX_VALUE; // declaring and initalizing mininum value to maximun Integer Value

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
    }
    
    //checking if value we are pushing on to stack is less than min value then push current minimum value on to stack
    // to keep track of min values and update min value to x
    //then push the value onto stack
    public void push(int x) {
        if(x<= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    //pop the top elament of the stack and check if it matches the min value
    // if so update the min value by popping the stored min value from stack
    public void pop() {
        int popped = stack.pop();
        if(min == popped){
            min = stack.pop();
        }
        
    }
    
    // return the top element from the stack
    public int top() {
        return stack.peek();
        
    }
    
    // returning min value.
    public int getMin() {
        return min;    
    }
}

