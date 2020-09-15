// Time Complexity : O(1)
// Space Complexity :O(N) - where N is size of the Stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class MinStack {

    /** initialize your data structure here. */
    int min = Integer.MAX_VALUE;
    //here we directly used the Stack data structure to perform peek(),pop() and push() operations
    Stack<Integer> s1;
    public MinStack() {
       s1 = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(x <= min){
            s1.push(min);
            min = x;
        }
        s1.push(x);
    }
    
    public void pop() {
        if(s1.peek() == min){
            s1.pop();
            min = s1.pop();
        }
        else{
            s1.pop();
        }
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
// Your code here along with comments explaining your approach
