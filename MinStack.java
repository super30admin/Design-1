
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//take 2 stacks and one min element
//push an infinite element on the minStack- 
//push the element on the stack and push the min element on the minStack
//Pop the element from the stack and min Stack and assign the min element with ninStack peek


class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;


    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        this.minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
         min = Math.min(min, val);
         stack.push(val);
         minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        this.min = minStack.peek();
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