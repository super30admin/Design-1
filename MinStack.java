// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MinStack {
    Node head;

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head == null)
            head = new Node(val,val,null);
        else
            head = new Node(val,Math.min(head.min,val),head);
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
    
    class Node{
        int val;
        int min;
        Node next;
        
        public Node(int val,int min,Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
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