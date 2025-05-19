// Time Complexity : O(1)
// Space Complexity : O(N) N number of nodes
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : This problem is optimized than what i have done with the Hashset. this reduces the space complexity depending on the size. But the only thing I
// can get is with space complexity of O(2N)  because if extra min variable that is being stored in every node
// I wasnt able to reduce the extra space of the min variable for every node.
//  Using a linkedList for the work


// Your code here along with comments explaining your approach

class MinStack {

    private Node head;

    public MinStack() {
      Node head = null;
    }
    
    public void push(int val) {
      // check if linkedlist is null
        if(head == null)
            head = new Node(val,val,head);
        else
            head = new Node(val, val < head.min ? val : head.min , head);
    }
    
    public void pop() {
      // check if linkedlist is null 
        if(head == null)
            return;
        head = head.next;
    }
    
    public int top() {
      // check if linkedlist is null
        if(head == null)
            return -1;
        return head.value;
    }
    
    public int getMin() {
      // check if linkedlist is null
        if(head == null)
            return -1;
        return head.min;
    }

  // creating the node structure for the LinkedList for working with stack
    class Node{
    int value;
    int min;
    Node next;

    private Node(int value , int min, Node head){
        this.value = value;
        this.min = min;
        this.next = head;
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
