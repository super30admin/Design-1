class MinStack {
    Stack<Integer> datastack;
    Stack<Integer> minstack;
/** initialize your data structure here. */
public MinStack() {
     datastack =new Stack<>();
    minstack = new Stack<>();
    minstack.push(Integer.MAX_VALUE);
}

public void push(int x) {
    datastack.push(x);
    minstack.push(Math.min(x, minstack.peek()));
    }

public void pop() {
    datastack.pop();
    minstack.pop();
}

public int top() {
    return datastack.peek();
}

public int getMin() {
    return minstack.peek();    }
}

/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(x);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/