// Time Complexity :O(1) for all functions
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :yes, function pop() while stack.peek() returns object 


// Your code here along with comments explaining your approach

/**
Base DS: Stack
to maintain the current min, use another Stack
*/
import java.util.Stack;

class MinStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    
    public MinStack() {
    }
    
    public void push(int val) {
        stack.push(val);
        // maintain min
        if (min.empty()) min.push(val);
        else if (min.peek() >= val) min.push(val);
    }
    
    public void pop() {            
        // if (stack.peek() == min.peek()) min.pop(); // It doesn't work is becoz peek() returns Integer object and two diff objects from two Stack are different'
        if (stack.peek().equals(min.peek())) min.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();        
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