// Time Complexity : 
//        push: O(1)
//        pop: O(1)
//        top: O(1)
//        getMin: O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * We are using a LinkedList Node to keep track of the element and corresponding global minimum
 * We update the global minimum when an element is less than global minimum and push it at the head of the list
 */

class MinStack {
    
    private Node head;

    class Node {
        int key;
        int value;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }
    
    /** initialize your data structure here. */
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        // if element is the first element
        if(head == null) {
            Node cur = new Node(val, val);
            head = cur;
        } else {
            // id linked list is not empty
            Node cur = new Node(val, Math.min(val, head.value));
            cur.next = head;
            head = cur;
        }
    }
    
    public void pop() {
        // when there are elements to remove, remove from head
        if(head != null) {
            Node next = head.next;
            head = next;
        }
    }
    
    public int top() {
        return head.key;
    }
    
    public int getMin() {
        return head.value;
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