// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack {

  //Initializing top/head node
    private Node top;

    //If top is equal to null, then initialize the top else create new node with top as next
    //At every push, check current val with current min, if its smaller, update min
    public void push(int x) {
        top = top == null ? new Node(x,x,null):new Node(x,Math.min(x, top.min),top);
    }

    //pop removes first element hence moving the top pointer by one place
    public void pop() {
        top = top.next;
    }

    //returns value on the top of the stack
    public int top() {
        return top.val;
    }

    //return min value from the stack
    public int getMin() {
        return top.min;
    }

     /** initialize your data structure here. */
    private class Node
    {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next)
        {
            this.val = val;
            this.min = min;
            this.next = next;
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
