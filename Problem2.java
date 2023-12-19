class MinStack {

    private class Node{
        int val;
        int min;
        Node next;
        public Node(int val, int msf, Node next){
            this.val = val;
            this.min = Math.min(val, msf);
            this.next = next;
        }
    }

    Node head;

    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if(head == null){
            head = new Node(val, val, null);
        } else {
            head = new Node(val, head.min, head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
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
