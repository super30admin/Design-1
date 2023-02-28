// Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : can also be implemented using 2 stacks 


class MinStack {
    Node head;

    public void push(int x) {
        if(head==null){
            head = new Node(x, x, null);
        }else{
            head = new Node(x, Math.min(x, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
       return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

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
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */