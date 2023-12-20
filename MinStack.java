class MinStack {
    List<Integer> stack;
    List<Integer> minIndices;
    public MinStack() {
        stack = new ArrayList<>();
        minIndices = new ArrayList<>();
    }

    public void push(int val) {
        if (stack.size() == 0) {
            minIndices.add(0);
        } else if (val <= getMin()) {
            minIndices.add(stack.size());
        }
        stack.add(val);
    }

    public void pop() {
        int elementToBeRemoved = stack.get(stack.size() - 1);
        if (elementToBeRemoved == getMin()) {
            minIndices.remove(minIndices.size() - 1);
        }
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return stack.get(minIndices.get(minIndices.size() - 1));
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