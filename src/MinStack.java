/*
 =I implement the stack using a singly linked list where each node stores (value, minSoFar).
On push, minSoFar is computed as min(val, currentMin) and stored in the new head node.
Top and getMin are always available at the head in O(1) time.
Time Complexity (average):
  push:      O(1)
  pop:   O(1)
  top: O(1)
  getMin: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO
Space Complexity:
  O(n)
*/

class MinStack {
    private static class Node {
        int val;
        int minSoFar;
        Node next;
        Node ( int val, int minSoFar, Node next){
            this.val = val;
            this.minSoFar = minSoFar;
            this.next =next;
        }
    }

    private Node head;
    public MinStack(){
        head = null;
    }
    public void push(int val) {
        if(head == null){
            head = new Node(val,val,null);
        }
        else{
            int newMin = Math.min(val,head.minSoFar);
            head = new Node(val,newMin,head);
        }

    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.minSoFar;
    }
}