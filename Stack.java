// Time Complexity : Finding element is O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I solved this using an Element class that stores value, minValue and pointer to the next element.
//                                           The solution is also here: https://www.programcreek.com/2014/02/leetcode-min-stack-java/. But,
//                                           ideally I would prefer this to be solved using two stacks, https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/.
//                                           The latter is much easier to understand.

class MinStack {

    public Element top;

    class Element {
        public int value;
        public int min;
        public Element next;

        public Element (int value, int min) {
            this.value = value;
            this.min   = min;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (top == null) {
            top = new Element(x,x);
        }
        else {
            Element elem = new Element (x, Math.min(x,top.min));
            elem.next = top;
            top = elem;
        }
    }

    public void pop() {
        if (top == null) {
            return;
        }
        Element temp = top.next;
        top.next = null;
        top = temp;
    }

    public int top() {
        if (top == null) {
            return -1;
        }
        return top.value;
    }

    public int getMin() {
        if (top == null) {
            return -1;
        }

        return top.min;
    }
}