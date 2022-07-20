// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class MinStack {
    Node head;

    static class Node {

        int data;
        int num;
        Node next;

        Node(int d)
        {
            this.data = d;
            this.num = d;
            this.next = null;
        }
    }

    public MinStack() {
    }

    public void push(int val) {
        Node newNode = new Node(val);

        if(head == null){
            head = newNode;
        } else {

            if( newNode.num > head.num){
                newNode.num = head.num;
            }

            newNode.next = head;
            head = newNode;
        }

    }

    public void pop() {
        head = head.next;


    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        return head.num;
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