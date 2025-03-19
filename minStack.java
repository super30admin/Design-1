// Design MinStack (https://leetcode.com/problems/min-stack/)

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
class MinStack {

    Stack <Integer> st;
    Stack <Integer> minSt;
    int min;
    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(min,val);
        minSt.push(min);
        st.push(val);
        
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        if(minSt.isEmpty()){
            min = Integer.MAX_VALUE;
        }
        else{
            min = minSt.peek();
        }
    }
    
    public int top() {
        return st.peek();
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