// Time Complexity :  O(1)
// Space Complexity : O(N) for extra space used to maintain Min Stack 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


class MinStack {

    private Stack<Integer> s;
    private Stack<Integer> minStack;
    int min;
    public MinStack() {
        min = Integer.MAX_VALUE;
        s = new Stack<>();
        minStack= new Stack<>();
        minStack.push(min); // initializing to min
    }
    
    // push to main stack
    // push the min value to minStack
    public void push(int val) {
        min=Math.min(min,val);
        s.push(val);
        minStack.push(min);
    }
    
    // pop from main stack and min Stack
    // update the min after pop
    public void pop() {
        s.pop();
        minStack.pop();
        min= minStack.peek();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
