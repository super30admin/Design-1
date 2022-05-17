// Time Complexity : O(1) for all operatoins
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class MinStack {
    
    private Stack<Integer> stack = new Stack<>();
    private Stack<int[]> minStack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        
        // if min stack is empty or number is smaller than top of min stack, put it on min stack with count of one
        if (minStack.isEmpty() || val < minStack.peek()[0]){
            minStack.push(new int[]{val, 1});
        }
        
        else if (val == minStack.peek()[0]){
            minStack.peek()[1]++;
        }
    }
    
    public void pop() {
        // if the top stack is same as top of min stack
        if (stack.peek().equals(minStack.peek()[0])){
            minStack.peek()[1]--;
        }
        
        // if count of min stack is now 0, remove completely
        if (minStack.peek()[1] == 0){
            minStack.pop();
        }
        
        stack.pop(); // alwauys pop main stack
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek()[0];
        
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