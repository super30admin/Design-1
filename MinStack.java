// Time Complexity : 
//push() - O(1)
//pop() - O(1)
//top() - O(1)
//getMin() - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class MinStack {
    private Stack<Integer> dataStack;
    private Integer min;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();
    //initialize min to maximum value
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
    //push twice if the element is less than or equal to min
        if(x <= min) {
            dataStack.push(min);
            min = x;
        }
        dataStack.push(x);
    }
    
    public void pop() {
        int pop = dataStack.pop();
    //pop the 2nd element if 1st element is equal to min
        if(pop == min){
            min = dataStack.pop();
        }
        
    }
    
    public int top() {
    //returns the top element of the stack
        return dataStack.peek();
    }
    
    public int getMin() {
    //returns the minimum value stored in min
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
