// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MinStack {
    Stack<Integer> s1;
    Stack<Integer> minStack;
    int min;
    public MinStack() {
        s1=new Stack<Integer>();
        minStack=new Stack<Integer>();
        min=Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int val) {
        min=Math.min(min, val);
        s1.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        s1.pop();
        minStack.pop();
        min=minStack.peek(); 
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
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */