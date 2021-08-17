// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : Tried to use the min variable in the Minstack class. 
It worked while pushing but didn't track the min value when poping. Then used min variable in each node instead. */

// Your code here along with comments explaining your approach
// Denition of a Node object containing min varaible.
class Node{
    int val;
    int min;
    Node next;
    Node(int val){
        this.val = val;
    }
}

public class MinStack {
    
    private Node head;

    public MinStack(){
        this.head = null;
    }

    // If head is empty then make the new node as head and assign the new value as min.
    public void push(int val){
        // New node object with the given value.
        Node newNode = new Node(val);
        // If head is empty then make the new node as head and assign the new value as min.
        if (head == null) {
            head = newNode;
            newNode.min = val;
        }
        // Else head is not empty then compare the given value with head's min value and assign it to the new node's min variable.
        // Move the current head to new node's next and assign the new node as head.
        else{
            newNode.min = Math.min(head.min, val);
            newNode.next = head;
            head = newNode;
        }
    }
    // Assign head's next value as head to remove the cuurent head.
    public void pop(){
        head = head.next;
    }
    // Return head's data.
    public int top(){
        return head.val;
    }

    // Return head's min value.
    public int getMin(){
        return head.min;
    }
}
