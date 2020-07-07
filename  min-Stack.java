// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class minStack {
    Stack <Integer> stack;
    Stack <Integer> minStack;
    int min;
    public minStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    public void push(int x) {
        stack.push(x);
        min = Math.min(min, x);
        minStack.push(min);
    }
    public int pop(){
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }
    public int top(){
        return stack.peek();
    }
    public int getMin()  {
        return minStack.peek();
    }
}