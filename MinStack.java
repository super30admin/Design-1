class Element {
    int v, min;

    public Element(int v, int min) {
        this.v = v; // value of element
        this.min = min; // min value
    }
}

/**
 * The simple way would be to use 2 stacks, one saves the element and other
 * running minimum The idea is to have use composite stack of type Element
 * defined above For first time, when stack is empty, the value of min = value
 * of element being inserted Otherwise, minimum value = min(element, TOS.min) In
 * other words we maintain the running minimum
 */
public class MinStack {

    Deque<Element> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        Element e;
        // stack empty, minimum is same as element itself.
        if (minStack.size() == 0) {
            e = new Element(x, x);
        } else {
            // otherwise, minimum is the minimum of element and TOS.
            e = new Element(x, Math.min(x, getMin()));
        }
        minStack.add(e);
    }

    /**
     * Removes the element on top of the stack.
     */
    public void pop() {
        minStack.removeLast();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return minStack.getLast().v;
    }

    /**
     * Retrieve the minimum element in the stack.
     */
    public int getMin() {
        return minStack.getLast().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */