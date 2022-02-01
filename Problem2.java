class MinStack {
    Node head;

    class Node  {
        int data;
        int min;
        Node next;

        public Node(int data, int min, Node next) {
            this.data = data;
            this.min = min;
            this.next = head;
        }
    }


    public MinStack() { }

    public void push(int val) {

        if (head == null) {
            head = new Node(val,val,null);
        } else {
            head = new Node(val, Math.min(val, head.data), head);
        }

    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.data;
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


// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
