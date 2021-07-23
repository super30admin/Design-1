// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> S;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        S = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val<=min){
            S.push(min);
            min = val;
        }
        S.push(val);
    }

    public void pop() {
        int value = S.pop();
        if (value == min){
            min = S.pop();
        }
    }

    public int top() {
        return S.peek();
    }

    public int getMin() {
        return min;
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