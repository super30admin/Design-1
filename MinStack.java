// Time Complexity : O(N)  - Push O(N), Pop O(1)
// Space Complexity : O(N) - No of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, straightforward

class MinStack {

    private Node head;
    
    public void push(int x) {
        if(head == null) 
            head = new Node(x, x, null);
        else 
            head = new Node(x, Math.min(x, head.min), head);
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
    
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    }
    