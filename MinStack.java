// Time Complexity : push is O(1) as all operation are done in constant time.
// Space Complexity : Used 2 stack so its O(2n) and Asympotic is O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : After the class, I was able to do problem and also understood it.

class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    Integer minimum;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        stack2.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        stack1.push(x);
        if(x < stack2.peek()){
            stack2.push(x);
            minimum = x;
        }
        else{
            stack2.push(minimum);
        }
    }
    
    public void pop() {
        if(!stack1.isEmpty()){
            stack1.pop();
        }
        if(!stack2.isEmpty()){
            stack2.pop();
        }
        minimum = stack2.peek();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return minimum;
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