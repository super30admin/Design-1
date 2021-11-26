// Time Complexity : O(1)
// Space Complexity : Amortised --> O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No. Sir explained it well


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> s;
    int min;
    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(min>=val){
            s.push(min);
            min = val;
        }
        s.push(val);
    }
    
    public void pop() {
        int popped = s.pop();
        if(popped == min){
            min = s.pop();
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
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */