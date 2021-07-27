// Time Complexity : push - O(1); pop - O(1); getMin - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MinStack {
    

    //initiating two stacks - one for elements and one for min values
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    //push to stack 1 and 2 for the first element and the min
    //subsequently elements will be compared to existing min and the lower value is pushed
    public void push(int val) {
        if (this.stack1.isEmpty()){
            stack1.push(val);
            stack2.push(val);
        }
        else {
            stack1.push(val);
            int getMin = this.getMin();
            if (val<getMin) {
                stack2.push(val);
            }
            else {
                stack2.push(getMin);
            }
            
        }
    }
    
    // pop both stacks when removing min
    public void pop() {
        stack2.pop();
        stack1.pop();
        
    }
    
    public int top() {
        return stack1.peek();
        
    }
    
    public int getMin() {
        return stack2.peek();
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


// Your code here along with comments explaining your approach
