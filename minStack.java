/* Code Explaination:

Here basically we are maintaining two staks. 
The one for pushing the values into the stack and 
the other one is minStack to maintain the minimum values of 
stack at each step of pushing and popping of a value.

We have a global minimum aswell.

The extra minSt allows tracking the minimum in constant time.
Even after popping, minSt maintains the correct minimum value for the remaining stack.

 Time Complexity : O(1)
 Space Complexity : O(n) - since minSt stores one value for each element
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : Need more understanding on the Time Complexity and Space Complexity


*/
import java.util.Stack;

class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minSt.push(min);
    }
    
    public void push(int val) {
        min = Math.min(min,val);
        st.push(val);
        minSt.push(min);
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek();
    }
    
    public int top() {
        return st.peek();
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