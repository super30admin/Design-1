// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {
    private Stack<Integer> s;
    int min;
    public MinStack() {
        min = Integer.MAX_VALUE;
        s = new Stack<>();
    }
    
    public void push(int val) {
       if(min >= val){
           s.push(min);
           min=val;
       }
       s.push(val); 
    }
    
    public void pop() {
        if(min == s.pop())
            min = s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}
