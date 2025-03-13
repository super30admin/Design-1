// Each Node stores:
// - The data (value).
// - The minimum value up to that point (minValue).
// - A reference to the previous node (next, which acts as the previous node in this case).

// Time complexities:
// - push: O(1)
// - pop: O(1)
// - top: O(1)
// - getMin: O(1)

class MinStack {
    class Node{
        int data;
        int minValue;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node top;
    int minElement;
    public MinStack() {
        top = null;
        minElement = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        Node newNode = new Node(val);
        if(top == null){
            newNode.next = null;
            newNode.minValue = newNode.data;
        } else {
            newNode.minValue = Math.min(top.minValue, newNode.data);
            newNode.next = top;
        }

        top = newNode;
    }
    
    public void pop() {
        if(top == null){
            return;
        }
        top = top.next;
    }
    
    public int top() {
        if(top == null){
            return -1;
        }
        return top.data;
    }
    
    public int getMin() {
        if(top == null){
            return -1;
        }
        return top.minValue;
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