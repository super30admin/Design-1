// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : N/A

class MinStack {

    // We need the head of linked list thats all
    // let us define the linked list now
    class NodeMin {
        int value;
        NodeMin next;
        int min; // imp variable which keeps the track of min when it was inserted

        public NodeMin(int value, NodeMin next, int min) {
            this.value = value;
            this.next = next;
            this.min = min;
        }
    }

    NodeMin head;

    public MinStack() {
    }

    public void push(int x) {
        if (head == null) {
            head = new NodeMin(x, null, x); // this case is simple
            return; // important
        }
        // insert the current element at head so tht it can be popped in LIFO
        // manner, imp is the min value stored here it is important to notice that
        // it in min of itself and wat was min till now, thts wat will stored
        // @ head.next, when we pop up the state will be maintained
        // whenever u pop them the next head will have its min for the time it will be popped
        head = new NodeMin(x, head, Math.min(x, head.min));
    }

    public void pop() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    public int top() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        return head.value;
    }

    public int getMin() {
        if (head == null) {
            return Integer.MAX_VALUE;
        }
        return head.min;
    }
}
