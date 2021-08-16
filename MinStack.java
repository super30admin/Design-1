// Time Complexity : Node contains current data, current minimum and next pointer, while pushing we push at top and assign its next the value of previous top - PUSH: O(1)
// POP is done from top as well - O(1)
// top - top node data is returned: O(1)
// get min - as we are maintaining minimum at top element - O(1)
// Space Complexity : As many elements are pushed is the space used: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Tried performing this with static array, causes Memory limit exceeded and linear time for minimum search

class MinStack {

    Node top;
    
    // Node maintaining data, minimum till now and next pointer
    class Node {
        int data;
        int min;
        Node next;
        Node(int data, int min, Node next) {
            this.data = data;
            this.min = min;
            this.next = next;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {
        // initialized top node to null
        top = null;
    }
    
    public void push(int val) {
        // performed empty check for stack
        if(top==null) {
            // if stack is empty assign top a new node
            top = new Node(val, val, null);
        } else {
            // new node is created and its next is assigned with current top
            Node currNode = new Node(val, Math.min(val, top.min), null);
            currNode.next = top;
            // change the top pointer to current node to keep it as top most element
            top = currNode;
        }
    }
    
    public void pop() {
        // nothing to perform if stack is empty
        if(top==null) {
            return;
        } else {
            // top is removed if we change top pointer to next node
            top = top.next;
        }
    }
    
    public int top() {
        // return data at the node at top pointer
        return top.data;
    }
    
    public int getMin() {
        // return minimum value maintained at top pointer
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