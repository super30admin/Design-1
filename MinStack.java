/**

Problem: Design a SplStack that supports all the stack operations push, pop, isEmpty, isFull and an operation getMin() which should return minimum element from the SplStack. All these operations must be O(1). To implement this, you should only use standard Stack data structure.
https://leetcode.com/problems/min-stack/
Solution:

Implemented stack by creating a 'Node' data structure that stores the current value, the minimum value, and a pointer to the next element (node);

- Time Complexity : Time complexity is O(1) for push(), pop(), top(), getMin()
- Space Complexity : Space complexity is O(n)
- Did this code successfully run on Leetcode : Yes
- Any problem you faced while coding this : No
*/

class MinStack {

    Node head;
    
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            int min = Math.min(val, head.minValue);
            head = new Node(val, min, head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.value;
    }
    
    public int getMin() {
        return head.minValue;
    }
    
    private class Node {
        int value;
        int minValue;
        Node next;
        
        public Node(int value, int minValue, Node next) {
            this.value = value;
            this.minValue = minValue;
            this.next = next;
        }
    }
}
