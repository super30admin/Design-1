// Min Stack using two Stacks 
// One Stack to keep track of values being added and another stack to keep track of minimum values
// This Approach passes leetcode test cases but is not that efficient Space Complexity wise.
class MinStack {

    Stack<Integer> mainStack; // Stack to keep track of values
    int min; // Variable to keep track of min value

   // Constructor for class MinStack
    public MinStack() {
        mainStack = new Stack<>();
        min = Integer.MAX_VALUE; 
    }
    
    // Method to push val in the Stack
    // Time Complexity: O(1)
    public void push(int val) {
        if (val<=this.min) // if value is less than or equal to current min value then we first keep a track old min value and then update it with new minimum value
        {
          mainStack.push(this.min);
          this.min = val; 
        }
       mainStack.push(val); 
    }
    
    // Method to remove topmost element of main stack
    // Time Complexity: O(1)
    public void pop() { 
      if(this.min == mainStack.pop()) // if the first element of the stack which is being popped is the min value then we pop that element and as we kept track of second least minnimum element thus we update min value with that and then pop it
      {
          this.min = mainStack.peek();
          mainStack.pop();
    }
    }
    // Time Complexity: O(1)
    public int top() { // returns int- topmost element of mainStack
        return mainStack.peek();
    }
    
    // Time Complexity: O(1)
    public int getMin() // returns int - min value 
    {
        return this.min;
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
