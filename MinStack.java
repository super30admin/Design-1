// Time Complexity : O(1)
// Space Complexity : O(1)
//Leetcode : https://leetcode.com/problems/min-stack/
class MinStack {

    private Stack<Integer> stack;
    private int minValue;
    public MinStack() {
        stack = new Stack<>();
        minValue = Integer.MAX_VALUE;
        stack.push(minValue);
    }
    
    public void push(int val) {
        if(val <= minValue){
            stack.push(minValue);
            minValue = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop() == minValue){
            minValue = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minValue;
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
