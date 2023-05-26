class MinStack {
    int arr[];
    int lastIndex;
    int minLastIndex;
    int count;
    int minArr[];
    int minimum;

    public MinStack() {
        arr = new int[30000];
        count = 0;
        lastIndex = minLastIndex = -1;
        minimum = (Integer.MAX_VALUE);
        minArr = new int[30000];
    }

    public void push(int val) {
        lastIndex++;
        arr[lastIndex] = val;
        count++;
        if (val <= minimum) {
            minimum = val;
            minLastIndex++;
            minArr[minLastIndex] = minimum;
        }
    }

    public void pop() {
        if (count == 0) {
            throw new IllegalStateException("Cannot pop from an empty stack.");
        }
        if (minArr[minLastIndex] == arr[lastIndex]) {
            minLastIndex--;
        }
        count--;
        lastIndex--;
        if (minLastIndex < 0) {
            minimum = Integer.MAX_VALUE;
        } else {
            minimum = minArr[minLastIndex];
        }
    }

    public int top() {
        if (count == 0) {
            throw new IllegalStateException("Empty stack.");
        }
        return arr[lastIndex];
    }

    public int getMin() {
        if (minLastIndex >= 0)
            return minArr[minLastIndex];
        return Integer.MAX_VALUE;
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