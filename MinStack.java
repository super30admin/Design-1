// Time Complexity : O(1)
// Space Complexity : O(n)

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
/*
 * I was initally using ArrayList and top and min varaibles
 * But I realized that minValue was not updated whenever top was removed
*/

// Your code here along with comments explaining your approach
/*
 * used two stacksc
 * One to push values
 * One to keep track of the minvalues and min value will always be on the top of this stack
*/

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || stack.peek() <= minStack.peek()) {
            minStack.push(val);
        }
        
    }
    
    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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