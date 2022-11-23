// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class MinStack {

    Stack<Integer> stack = new Stack(); //Instantiate stack to store the pushed values
    int minVal = Integer.MAX_VALUE; //Initialize a variable minVal to infinity. It will store the minimum value of stack elements

    public MinStack() {
        
    }
    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public void push(int val) {
        if(val <= minVal){ //Check if the value being pushed is less than or equal to the current minVal
            stack.push(minVal); //In case we pop off the minimum, we need to have the second minimum on top so that it can be popped and used as new minimum
            minVal = val; //Assign the value being pushed to minVal if it is less than or equal to minVal
        }
        stack.push(val); //Push the element onto the stack anyway
    }
    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public void pop() {
        if(stack.pop() == minVal){ //If the element being popped is equal to minVal, pop stack again and assign it to minVal because we have it right below the original minVal
            minVal = stack.pop();
        }
    }
    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public int top() {
        return stack.peek(); //Return the element at the top of the stack
    }
    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public int getMin() {
        return minVal; //Return the value stored in minVal variable
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