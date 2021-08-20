// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : 

/*
    We will be using a singly linked list DS to solve this problem.
    The Node structure will consist of a pointer to the next node and a value.
*/
class MinStack {

    /** initialize your data structure here. */
    Node top;

    // Constructor
    class Node{
        int data, min;
        Node next;

        Node (int data) {
            this.data = data;
            min = 0;   
        }
    }


    public MinStack() {

    }

    public boolean isEmpty() {
        if (top == null)
            return true;
        else
            return false;
    }
    
    public void push(int val) {
        Node new_node = new Node (val);
        if (isEmpty()) {
            new_node.min = val;
            top = new_node;
        }
        else {
            new_node.min = Math.min(val, top.min);
            Node temp = top;
            top = new_node;
            new_node.next = temp;
        }
        
    }
    
    public void pop() {
        if (isEmpty()) {
            return;
        }
        else
            top = top.next;
        
    }
    
    public int top() {
        if (isEmpty()) {
            return -1;
        }
        else
           return top.data;
        
    }
    
    public int getMin() {
        return top.min;
        
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
