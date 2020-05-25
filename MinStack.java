// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack {
    private Node root;
    int min = 999999;
    static class Node{
        int data;
        int min;
        Node next;
        
        Node(int data,int min){
            this.data=data;
            this.min=min;
            next=null;
        }
    }
    
    public void push(int x) {

        Node temp=new Node(x,x);
        if(root==null){
            temp.min=x;
            root=temp;
            
        }
        else{
            temp.min=Math.min(x,root.min);
            temp.next=root;
            root=temp;
        }
    }
    
    public void pop() {
            root=root.next;
        }
    
    
    public int top() { 
        return root.data;
    }
    
    public int getMin() {
        return root.min;
    }
}