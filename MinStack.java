/**
 * 
 * Implementation involves using a linked list, where each node maintains the minimum value. 
 * Since a new node is inserted or deleted at the head, it mimics the behavior of a Stack.
 * 
 * Space complexity is O(n)
 * Time complexity for all the methods is O(1) as we have a reference to the head and all the values are accessed
 * at the head without having to traverse through the list.
 * 
 * 
 * 
 */

class MinStack {
    
    Node head;
    public void push(int val) {
        if(head == null) {
            head = new Node(val, val, null);
        }
        else {
            head = new Node(val, Math.min(head.min, val), head);
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
  
    private class Node {
        int val;
        int min;
        Node next;
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}