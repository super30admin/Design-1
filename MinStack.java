
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used some resources

    class MinStack {

        private Node head;

        public void push(int val) {

            //initializing the min with current value
            int min = val;
            if (head != null) {
                //comparing val and min
                min = Math.min(min, head.min);
            }

            Node newNode = new Node(val, min);
            newNode.next = head;
            head = newNode;
        }

        public void pop() {
            //sets the head to the next value
            head = head.next;
        }

        public int top() {
            //returns the head value
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        //creating a node class with val and min
        private static class Node {

            private int val;
            private int min;
            private Node next;

            //constructor
            private Node(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }



        public static void main(String args[]) {


            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            minStack.getMin(); // return -3
            minStack.pop();
            minStack.top();    // return 0
            minStack.getMin(); // return -2
            System.out.println(minStack.getMin());
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