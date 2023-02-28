// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class MinStack {
    class Node{
        Node next;
        int val;
        int min;
        Node(int data, int low, Node next){
            this.val = data;
            this.min = low;
            this.next = next;
        }
    }
 
    Node head;

    public MinStack() {
        head  = null;
    }
    
    public void push(int val) {
        if(head ==  null){
            head = new Node(val,val,null);
        }else{
            head = new Node(val, Math.min(head.min,val),head);
        }
    }
    
    public void pop() {
        if(head!=null)
            head = head.next;
    }
    
    public int top() {
        if(head!=null){
            return head.val;
        }
        return -1;
    }
    
    public int getMin() {
        if(head != null)
            return head.min;
        return -1;
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
