//Time Complexity - O(1) for all operations
//Space Complexity-  O(N) where n is the number of elements

class MinStack {
    Node head;

    class Node {
        int data;
        Node next;
        int min;

        Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    public MinStack() {

    }

    public void push(int val) {

        Node newNode = new Node(val);
        if (head != null) {
            newNode.min = head.min < val ? head.min : val;
        } else {
            newNode.min = val;
        }
        Node temp = head;
        head = newNode;
        newNode.next = temp;
    }

    public void pop() {
        if (head == null)
            return;
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