// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

//I will take a variable and keept track of the min all the time, it the current min is less that
// the actual min I will update the min variable.


class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        
        if(x<=min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
        
    }
    
    public void pop() {
        if(stack.pop()==min){
            min=stack.pop();
        }
    }
    
    public int top() {
        if(stack.size()>0){
            return stack.peek();
        }
        return -1;
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