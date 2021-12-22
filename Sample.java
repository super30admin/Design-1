// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MinStack {
    
    private Node top;

    public MinStack() {
        top = new Node(0,Integer.MAX_VALUE,null);    
    }
    
    public void push(int val) {
        top = val < top.min ? new Node(val, val, top) : new Node(val, top.min, top);
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

class Node {
    int val;
    int min;
    Node next;
    Node(int v,int m, Node n){
        this.val = v;
        this.min = m;
        this.next = n;
    }
}