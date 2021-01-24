// Min Stack
// T: O(1)
// S: O(1) without considering initial usage of needed structure - stack
class MinStack {

    Deque<Integer> deque;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        deque = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x<=min){
            deque.push(min);
            min = x;
        }

        deque.push(x);
    }

    public void pop() {
        int val = deque.pop();

        if(min==val){
            min = deque.pop();
        }
    }

    public int top() {
        return deque.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */