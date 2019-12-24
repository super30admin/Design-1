class MinStack {

    public EValue top;

    class EValue {
        public int value;
        public int min;
        public EValue next;

        public EValue (int value, int min) {
            this.value = value;
            this.min   = min;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (top == null) {
            top = new EValue(x,x);
        }
        else {
            EValue elem = new EValue (x, Math.min(x,top.min));
            elem.next = top;
            top = elem;
        }
    }

    public void pop() {
        if (top == null) {
            return;
        }
        EValue temp = top.next;
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