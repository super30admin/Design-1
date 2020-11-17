package com.design1;
class Node
{
    int data;
    int min;
    Node next;

    public Node(int d, int m)
    {
        data = d;
        min = m;
        next = null;
    }

    public Node(int d, int m, Node next)
    {
        data = d;
        min = m;
        this.next = next;
    }
}

class MinStack {
    private Node head;

    public void push(int x) {
        if (head == null) {
            head = new Node (x, x);
        } else {
            head = new Node (x, Math.min (x, head.min), head);
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


    public static void main(String args[]) {
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
