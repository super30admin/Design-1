//Design MinStack (https://leetcode.com/problems/min-stack/)
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Solved using two stack

class MinStack {
Stack<Integer> stk;
Stack<Integer> minstack;
    public MinStack() {
        stk = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        if(minstack.isEmpty()==true || val<=minstack.peek()){
            minstack.push(val);
        }
        stk.push(val);
    }
    
    public void pop() {
        if(stk.peek().equals(minstack.peek())){
            minstack.pop();
        }stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minstack.peek();
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
