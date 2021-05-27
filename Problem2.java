
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s;
    int minEle;

    public MinStack() {
        s = new Stack<>();
        minEle = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= minEle) {
            s.push(minEle);
            minEle = x;
        }

        s.push(x);
    }

    public void pop() {
        int popped = s.pop();
        if (popped == minEle) {
            minEle = s.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minEle;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */

// Time and Space analysis
/*
 * Time Complexity : O(1)
 * 
 * Space complexity : O(n)
 */