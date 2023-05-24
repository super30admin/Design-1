// Time Complexity : O(1) for push , pop and getmin
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Implentation using single stack

class MinStack {

Stack<Integer>  minStack;
int min = Integer.MAX_VALUE;
public MinStack() {
 minStack = new Stack<>();
}

public void push(int val) {
    // Ignoring empty check as problem statement mentions that this operation wont be called on non empty stacks
    //if current value is less than min then push the old min and update the min value
    if(val<= min){
        minStack.push(min);
        min = val;
    }
    minStack.push(val);
}

public void pop() {
   // Ignoring empty check as problem statement mentions that this operation wont be called on non empty stacks
   //if the top of stack is equal to min then set min to top and pop twice 
  if( min == minStack.pop()){
      min = minStack.pop();
    }
}

public int top() {
        // Ignoring empty check as problem statement mentions that this operation wont be called on non empty stacks
    return minStack.peek();
}

public int getMin() {
        // Ignoring empty check as problem statement mentions that this operation wont be called on non empty stacks
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