//Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes cannot be done with just arrays


public class MinStack {
    Node top;
    
    /** initialize your data structure here. */

    class Node{
        int num;
        int min;
        Node prev;
    }
    
    public void push(int num) {
        Node temp_Node = new Node();
        temp_Node.num = num;
        
        if((top==null) || (num<top.min))
            temp_Node.min = num;
        else
            temp_Node.min = top.min;

        temp_Node.prev = top;
        top = temp_Node;
        
    }
    
    public void pop() {
        top = top.prev;
    }
    
    public int top() {
        return top.num;
        
    }
    
    public int getMin() {
        return top.min;
    }
    
}
