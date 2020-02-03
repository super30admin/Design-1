// Time Complexity : O(1)
// Space Complexity : O(N) where N is number of values inserted in stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Trying to come up with 1 stack solution was challenging


// Your code here along with comments explaining your approach

//Basic idea is to store old minimum and new minimum consecutively in stack i.e. every old/new min will have pushes to stack multiple times
//This is to easily update old min value when pop() is called


class MinStack {

    /** initialize your data structure here. */
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    
    public void push(int x) {
        //Push old minimum just before new minimum again if it is greater than current minimum

        if(x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
        
    }
    
    public void pop() {
        //Pop old minimum along with new minimum to update min
        if(stack.pop() == min) {
            min=stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

// If no stack library has to be used: use linkedlist node with 2 values: val and min. Every node has its min always updated
class MinStack {

    private Node head; 
    public void push(int x) {
        // Update min by comparing old min and new value
        if(head == null) 
            head = new Node(x,x);
        // current node would be new head
        // its next node would be old head
        else 
            head = new Node(x,Math.min(x,head.min),head);
    }
    
    public void pop() {
        //remove head 
        head = head.next;   
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    
    private class Node {
        int val, min;
        Node next;
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
        
        private Node(int val,int min) {
            this(val,min,null);
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