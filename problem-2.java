// Approach
// 1. Maintain a varible 'min' which always has the minimum elemnt
// 2. maintain the precvious min and the current min in the same stack so that if the current min element is popped then we can 
// update the varible min to the precvious minimum value


// Time Complexity : push - O(1) , pop - O(1) , getMin - O(1)
// Space Complexity : O(1) when items pushed are in descending order
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s=new Stack<>();
    int min = Integer.MAX_VALUE;
    
    public MinStack() {
    
    }
    
    public void push(int x) {
        if (x<=this.min){
            //push previous min
            this.s.push(this.min);
            this.min = x;
            this.s.push(this.min);
        }
        else{
            this.s.push(x);
        }
    }
    
    public void pop() {
       int poppedItem = this.s.pop();
        if (poppedItem == this.min)
            {
                this.min = this.s.pop();
            }
        }
    
    public int top() {
        return this.s.peek();
        
    }
    
    public int getMin() {
        return this.min;
        
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
