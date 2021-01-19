// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> stack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;    //Initialize stack and set min to the largest integer
    }
    
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;                //push curr min to the stack to keep tack of all mins 
        }
        stack.push(x);
    }
    
    public void pop() {
        int pop = stack.pop();
        if (pop == min)
            min = stack.pop();      //if min element is popped, pop out the next minimum that we saved in the stack
    }
    
    public int top() {
        return stack.peek();        //return the top element
    }
    
    public int getMin() {
        return min;                 //return the minimum element
    }
}
