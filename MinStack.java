/**Space Complexity:O(1) -We just use one node i.e., head node.
 *Time Complexity:For all the operations - it is O(1).
 *Approach: I have designed the minstack based on the linked list approach.Whenever a new node is added, the head is changed to that node.I have updated the min then and there for O(1) retrival.
 *Runs on Leet code.
 */
class MinStack {
     private Node head;
    /** initialize your data structure here. */
    public MinStack() {
       }
    public void push(int x) {
         if(head==null){
            head= new Node(x,x);
        }
        else{
            Node temp=head;
            head=new Node(x,Math.min(x,head.min),temp);
        }
        
    }
    
    public void pop() {
        head=head.next;
    }
    
    public int top() {
     return head.value;
    }
    
    public int getMin() {
        return head.min;
    }


class Node{
    int value;
    int min;
    Node next;
    private Node(int value,int min){
        this.value=value;
        this.min=min;
        this.next=null;
    }
    
    private Node(int value,int min,Node next){
        this.value=value;
        this.min=min;
        this.next=next;
        
    }
}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */