// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> stack; 
    Stack<Integer> mincount;
    int minval;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        mincount = new Stack<>();
        minval = Integer.MAX_VALUE;
        mincount.push(minval);
    }
    
    public void push(int val) {
        stack.push(val);
        minval=Math.min(minval, val);
        mincount.push(minval);    
    }
    
    public void pop() {
        stack.pop();
        mincount.pop(); 
        minval=mincount.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mincount.peek();
    }
}