//The MinStack class is a stack data structure that allows you to push and pop elements,
//as well as retrieve the minimum element in the stack in constant time.
//It does this by maintaining a reference to the minimum element at each level of the stack.
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes

class MinStack {
    
    class Node{
        int val;
        int min;
        Node next;
        public Node(int val, int min, Node next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
    }

    private Node head;

    public MinStack() {
        head=null;
    }
    
    public void push(int val) {
        if(head==null){
            head= new Node(val,val, null);
        }
        else{
            head= new Node(val, Math.min(val, head.min), head);          
        }
    }
    
    public void pop() {
        head= head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
