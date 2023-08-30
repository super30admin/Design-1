// Min Stack using two Stacks 
// One Stack to keep track of values being added and another stack to keep track of minimum values
// This Approach passes leetcode test cases but is not that efficient Space Complexity wise.
class MinStack {

    Stack<Integer> mainStack; // Stack to keep track of values
    Stack<Integer> minStack; // Stack to keep track of Minimum value
    int min; // Variable to keep track of min value

   // Constructor for class MinStack
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE; 
    }
    
    // Method to push val in the Stack
    // Time Complexity: O(1)
    public void push(int val) {
        
        if (this.min>val)
        {
          this.minStack.push(val); // If the value is less than current min value then replace the min value with current value and update current value in minStack
          this.min = val;
        }
        else {
         this.minStack.push(min); // If the value is greater than current min value then dont replace the min value with current value and update existing min value in minStack
        }

        this.mainStack.push(val);  // add value to main Stack which is keeping track of the values
    }
    
    // Method to remove topmost element of main stack
    // Time Complexity: O(1)
    public void pop() { 
      this.minStack.pop(); // removing data from main Stack
      this.mainStack.pop(); // Removing data from min Stack
      this.min = getMin(); // Updating min value post deletion of top value from stack
    }
    
    // Time Complexity: O(1)
    public int top() { // returns int- topmost element of mainStack
        return this.mainStack.peek(); // Topmost value in main stack
    }
    
    // Time Complexity: O(1)
    public int getMin() // returns int - min value 
    {
        if (this.minStack.empty()) // taking care of edge case ig the minStack is empty return infinity
        {
            return Integer.MAX_VALUE;
        }
     return this.minStack.peek(); // return minimum value by returning topmost element of minStack
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
