// Time Complexity :  - PUSH: O(1), POP - O(1),top -: O(1), get min - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No Problem faced

class MinStack {

    Node top;
    
    class Node {
        int data;
        int min;
        Node next;
        Node(int data, int min, Node next) {
            this.data = data;
            this.min = min;
            this.next = next;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {
        top = null;
    }
    
    public void push(int val) {
      
        if(top==null) {
            top = new Node(val, val, null);
        } else {
            Node currNode = new Node(val, Math.min(val, top.min), null);
            currNode.next = top;
            top = currNode;
        }
    }
    
    public void pop() {
        if(top==null) {
            return;
        } else {
            top = top.next;
        }
    }
    
    public int top() {
        return top.data;
    }
    
    public int getMin() {
        return top.min;
    }
}