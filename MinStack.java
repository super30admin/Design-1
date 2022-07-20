// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * for every new element, we maintain a current minimum in a custom DataStructure
 * We always push, pop and return top from the head of the LinkedList structure.
 */

class MinStack {
    
    // Defining a custom Data structure for keeping the value and current minimum
    class Node {
        int val;
        int min;
        Node next;
        
        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
    
    private Node head;

    public MinStack() {
        head = null;
    }
    
    /**
     * If head is null, head will be th new node with the val and minimum as val
     * If head is not null, then create a new node with val and current minimum and head will point to the new node
     */
    public void push(int val) {
        Node newNode;
        
        if (head == null) {
            head = new Node(val, val);
        } else {
            newNode = new Node(val, Math.min(val, head.min));
            newNode.next = head;
            head = newNode;
        }
    }
    
    // For popping, we simply point the head to its next node.
    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }
    
    public int top() {
        return head.val;
    }
    
    /**
     * Head will always contain the minimum value
     * We simply return the minimum value
     */
    public int getMin() {
        return head.min;
    }
}