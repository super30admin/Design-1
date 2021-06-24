import java.util.Stack;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack2 {

    //In this approach, we shall use 2 stacks
    Stack<Integer> stack, minStack;

    /** initialize your data structure here. */
    public MinStack2() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {

        //compare to top of minStack as that is the current minimum
        //if smaller, the it is new min so add to minstack
        if(val <= minStack.peek()){
            minStack.push(val);
        }
        //not new min so just add old min again
        else{
            minStack.push(minStack.peek());
        }
        //val mushed be pushed in normal stack regardless
        stack.push(val);
    }
    
    public void pop() {
        //pop from both to keep the same level
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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