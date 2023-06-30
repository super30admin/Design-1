import java.util.Stack;

// Time Complexity : 0(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
//used two stack approach
class MinStack {
    Stack<Integer> s1 = new Stack<> ();
    Stack <Integer> s2 = new Stack<> ();
    public MinStack() {
        s2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        s1.push(val);
        if(val <= s2.peek()) {
            s2.push(val);
        }
        else{
            s2.push(s2.peek());
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
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