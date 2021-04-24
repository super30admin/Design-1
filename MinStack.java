// Time Complexity : push(): O(1), pop(): O(1), top(): O(1), min: O(1)
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> mainStack;
    int min=Integer.MAX_VALUE; //storing max value in the min var as this is used in initial comaprision. And should be max to begin with
    /** initialize your data structure here. */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
        //minStack.push(min);
    }
    
    public void push(int val) {
        min=Math.min(min,val); //storing the min value in the min var. This var will always hold the current min value
        mainStack.push(val); //pushing the value in the main stack 
        minStack.push(min); //push the corresponding min - each val that has been pushed to the main stack will have a min pushed to the minStack corresponding to 
        //its value
    }
    
    public void pop() {
        //while popping, pop the element from main stack, but also pop its corresponding min value from the minStack
        //this will also require resetting the value for the min var that holds the current min value
        //if removing value resulted in emptying the minStack, min var will have to be reset to max value
        //otherwise, read top element from minStack, as it is the next min value and store it in the min variable
        mainStack.pop();
        minStack.pop();
        if(minStack.empty())
            min=Integer.MAX_VALUE;
        if(!minStack.empty())
            min=minStack.peek();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        //just return the variable that holds the min val
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
