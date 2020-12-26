// Time Complexity : O(1)
// Space Complexity : O(2n) but constants don't matter so O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MinStack {
    Stack<Integer> mainSt;
    Stack<Integer> minSt;
    Integer min;
    /** initialize your data structure here. */
    public MinStack() {
        mainSt = new Stack<>();
        minSt = new Stack<>();
        min = Integer.MAX_VALUE;
        minSt.push(min);
    }
    
    public void push(int x) {
        min = Math.min(min,x);
        mainSt.push(x); minSt.push(min);        
    }
    
    public void pop() {
        mainSt.pop(); minSt.pop();
        min = minSt.peek();
    }
    
    public int top() {
        return mainSt.peek();
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