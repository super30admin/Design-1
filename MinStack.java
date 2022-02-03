// Time Complexity O(1)
// Space Complexity O(1)

class MinStack {
    
    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<Node>();
    }
    
    public void push(int val) {
        
        Node newNode = new Node(val);
        
        if(stack.isEmpty()) {
            newNode.min = val;
            stack.push(newNode);
            
            return;
        }
        
        Node node = stack.peek();
        newNode.min = node.min > val ? val : node.min;
        stack.push(newNode);  
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

class Node {
    int val;
    int min;
    
    public Node(int data) {
        this.val = data;
    }
}

