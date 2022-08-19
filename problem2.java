
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Syntax Errors while coding for java,
//Problem apporach was explained in class, we use two stacks one stack for the actual stack and other for min value



class MinStack {
    /** initialize your data structure here. */
    Stack<Integer>s;
    Stack<Integer>minStack;
    int min;
    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
      min =Integer.MAX_VALUE;
        minStack.push(min);
    }
    public void push(int val) {
        if(val<=min){
            min = val;
        }
        s.push(val);
        minStack.push(min);
    }
    public void pop() {
        s.pop();
        minStack.pop();
        min = minStack.peek();
    }
    public int top() {
        return s.peek();
    }
    public int getMin() {
        return min;
    }
}