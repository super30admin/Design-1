// Time Complexity : Push: O(1), POP : O(1), getMin: O(1)
// Space Complexity : O(n) for stroing n elements
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// I am using a linked list in which i have a varaible for holding the current value, a variable
// for golding the minimum value seen till now and a pointer for the next node.



class MinStack {

    Node head;

    public MinStack() {
        head = null;
    }

    public void push(int val) {
       if(head == null)
           head = new Node( val, val, null); // if head is null then stack is empty so create a node
        else{
            int min = Math.min(val, head.min); // else stack already has elements.// push the value along with minimum value seen till now.
            head = new Node(val, min, head); // make the new node as head
        }
    }

    public void pop() {
        head = head.next; // point head to node head was pointing before.
        }

    public int top() {
        return head.val; // head.val has the value on top of the stack
    }

    public int getMin() {
        return head.min; // head.min always holds the minimum value seen till now.
    }

    class Node{
        int val;
        int min;
        Node next;

        Node (int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
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
