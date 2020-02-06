// Time Complexity : O(1) for all opertions
// Space Complexity : O(n) where n is the size of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class designMinStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int min = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public MinStack() {
        s2.push(min);    
    }
    
    public void push(int x) {
        if (x < min) {
            min = x;
        }    
        s1.push(x);
        s2.push(min);
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
        min = s2.peek();
    }
    
    public int top() {
        return s1.peek();    
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