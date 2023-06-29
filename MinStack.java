// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach - 1 Stack with Pair
class MinStack {
    
    class Node {
        int val;
        int min;
        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
    
    Stack<Node> stack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(new Node(x, x));
            return;
        }
        int min = Math.min(stack.peek().min, x);
        stack.push(new Node(x, min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */