// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack {
    
    Stack <Integer> splStack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        splStack = new Stack<>();
        //initialise the min variable with max value
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        //if x is less that equal to min, push current min in the stack
        //push x in the stack
        //make x as the new min
        if(x <= min ){
            splStack.push(min);
            min = x;
        }
        splStack.push(x);
    }
    
    public void pop() {
        int value = splStack.pop();
        //if stack.pop() == current min, again pop() and make it as new min
        if(value == min){
           min = splStack.pop();
        }
    }
    
    public int top() {
        return splStack.peek();
    }
    
    public int getMin() {
        //min is the current minimum value
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