
import java.util.Stack;

class MinStack {
    
     // Time Complexity:: push() - O(1), pop - O(1), top() - O(1), getMin() - O(1)
     // Space Complexity:: O(n) 
     // The code ran successfully on leetcode

    Stack<Node> stack;

    // Use Node class to push objects in the stack
    public MinStack() {
        stack = new Stack<Node>();
    }

    // Every time a Node object is pushed into the stack, we check 
    // if the node's val is less than stack's top element minVal. 
    // Based on that, we assign Node object's minVal. 
    public void push(int val) {
        Node node = new Node(val);
        if (stack.isEmpty()) {
            node.minVal = val;
            stack.push(node);
        } else {
            if (stack.peek().minVal < val) 
                node.minVal = stack.peek().minVal;
            else
                node.minVal = val;
            stack.push(node);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().minVal;
    }
}

class Node {
    int val;
    int minVal;
    public Node(int val) {
        this.val=val;
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
