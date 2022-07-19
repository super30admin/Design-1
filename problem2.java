// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Used the same approch for stack which I used during the precourse but added a new int variable to mainian min value at any given top value. 
//So newly added value will be top and that'll point to last top node in next pointer. In this case if you pop, you'll have top.next as new top which
//even has correct min value. That way even if you pop current min value. older heads will have correct min values.

class MinStack {
    
    class Node{
        int val;
        int min;
        Node next;
        
        public Node(int val,int min,Node next){
            this.val =val;
            this.min =min;
            this.next =next;
        }
    }
    
    Node top;
    
    public MinStack() {
    }
    
    public void push(int val) {
        if(top == null){
            top = new Node(val,val,null);
        }
        else{
            top = new Node(val,Math.min(top.min,val),top);
        }
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.min;
    }
}
