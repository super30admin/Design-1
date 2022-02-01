// Time Complexity : O(1) for push, pop, top, getMin
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
//Create stack of array
//Each array would have min value and top of the stack value
//We will always compare and store the latest min value on push
//We implement pop, top, getMin as well
class MinStack {
    private Stack<int[]> stack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val, val});
            return;
        }
        int min = stack.peek()[1];
        stack.push(new int[]{val ,Math.min(val ,min)});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    public int getMin() {
        return stack.peek()[1];   
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