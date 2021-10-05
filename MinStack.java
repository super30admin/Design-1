// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// I have not use isFull function as I am using Linked list it will go for how many nodes it want.


// Your code here along with comments explaining your approach

class MinStack {
    Node head;
    class Node {
        int data;
        int min;
        Node next;
        Node prev;
        Node(int d,int min){
            this.data = d;
            this.min = min;
            this.next = null;
            this.prev = null;
        }
    }
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if(head == null){
            head = new Node(val,val);   
        }
        else{
            head.next = new Node(val,Math.min(val,head.min));
            head.next.prev = head;
            head = head.next;
        }
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void pop() {
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        head = head.prev;
    }
    
    public int top() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return head.data;
    }
    
    public int getMin() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return head.min;
    }
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(10);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
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