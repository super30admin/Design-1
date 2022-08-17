//Method 1: 1:1 mapping
// Time Complexity : O(1) for push,pop and top operations
// Space Complexity : O(n) - two stacks of size n i.e., O(n)+ O(n) = 2 O(n) ~=O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        this.st = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {
        min = Math.min(min, val);
        st.push(val);
        minStack.push(min);
    }

    public void pop() {
        st.pop();
        minStack.pop();
        min = minStack.peek();
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

/**
 Another approach - using only one stack and adding prev min to stack if min >= value
 class MinStack {

 private Stack<Integer> st;
 private int min;

 public MinStack() {
 this.st = new Stack<>();
 this.min = Integer.MAX_VALUE;
 }

 public void push(int val) {
 if(min >= val){
 st.push(min);
 min = val;
 }
 st.push(val);
 }

 public void pop() {
 if(min == st.pop()){
 min = st.pop();
 }
 }

 public int top() {
 return st.peek();
 }

 public int getMin() {
 return min;
 }
 }
 */