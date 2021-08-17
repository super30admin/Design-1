// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I tried using ArrayList first but got a bad time complexity.

class MinStack {

    Node top;

    class Node{
        int num;
        int min;
        Node prev;
    }

    public void push(int num) {
        Node tempNode = new Node();
        tempNode.num = num;

        //check if top node has been initiliazed
        if((top==null) || (num<top.min))
            tempNode.min = num;
        else
            tempNode.min = top.min;

        tempNode.prev = top;
        top = tempNode;
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */