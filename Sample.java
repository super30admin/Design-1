// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * @auther = PRAYAG PATEL
 * @problem = S30 FAANMG Problem #2 {Medium} / Leetcode 155. Min Stack {easy}
 * @asked  = Microsoft
 */



import java.util.Stack;


class MinStack {
    public  Stack<Integer>stack;
    public Stack<Integer>mini;
    public MinStack() {
        stack = new Stack<>();
        mini = new Stack<>();        
    }
    
    public void push(int val) {
        if(stack.empty() || val<=mini.peek())
        {
            mini.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.peek().equals(mini.peek()))
        {
            mini.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    
        
    }
    
    public int getMin() {
        return mini.peek();
        
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
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
