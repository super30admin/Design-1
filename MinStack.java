// Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// Your code here along with comments explaining your approach

class MinStack {

    private Node head;

    private class Node{
        int min;
        int val;
        Node next;

        //Counter
        Node(int val){
            this.min = val;
            this.val = val;
            this.next = null;;
        }
    }
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        Node newNode = new Node(val); 

        if( head == null){
            head = newNode; 
        }
        else{
            //Update min by finding smaller value b/w the current min and       new           element
            newNode.min = Math.min(val, head.min);
            //Make current head as the next of new node
            newNode.next = head;
            // Make head poit to the new node
            head = newNode;
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
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */