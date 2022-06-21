// Time Complexity :
//   Push: O(1)
//   POP: O(1)
//   Top: O(1)
//   Min: O(1)
 
// Space Complexity :
//    Best Case/Avg. O(1)
//    Worst Case: O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class MinStack {

  // Initializing stack and the min value
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    public MinStack() {
       stack = new Stack<>();
    }
    
  // check value with min, if it is lesser then push min, change min to val and then push val
    public void push(int val) {
        if(val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
  
  // Check min with current top element if min and current top are equal,
  // remove top and make next top min by popping out, So that we can store next min value  
    public void pop() {
        if(min == stack.pop()) min =stack.pop();
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
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
