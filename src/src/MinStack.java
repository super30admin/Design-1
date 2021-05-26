//TC : O(1) for all operations
//SC : 0(n)
// Did this code successfully run on Leetcode : Yes, 92% faster and 31% less memeory usage
// Any problem you faced while coding this : No
class MinStack {
    private Node head;

    //while pushing the element itself we keep a track of the minimum element so far and attach the value to the node
    public void push(int x) {
        if(head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    //push head forwadrd by one step to pop the top element
    public void pop() {
        head = head.next;
    }

    //top element is stopred in head, so return head.val
    public int top() {
        return head.val;
    }

    //return the minimum so far
    public int getMin() {
        return head.min;
    }

    //used a class Node and every object will hold a variable "min" that represents the min value so far
    private class Node {
        int val;
        int min;
        Node next;


        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String args[])
    {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("The min element  is "+minStack.getMin()); // return -3
        minStack.pop();
        System.out.println("The top element  is "+minStack.top());   // return 0
        System.out.println("The min element after popping is "+minStack.getMin());// return -2
    }

    //Output :
    // The min element  is -3
    //The top element  is 0
    //The min element after popping is -2
}