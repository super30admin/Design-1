Time: O(1) for all
Space: O(N) auxillary stack
LeetCode: Yes
Any issue: No


class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s=new Stack<>();
    
    public MinStack() {
    }
    int min=Integer.MAX_VALUE;
    public void push(int x) {
        if(x<=min){
            s.push(min);
            min=x;
        }
        s.push(x);
    }
    
    public void pop() {
        int popped = s.pop();
        if(popped==min){
            min=s.pop();
        }
    }
    
    public int top() {
        return s.peek();
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
