// Time Complexity : O(1)
// Space Complexity : O(N) stack would be O(n+n)-> O(2n) ==> O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : Yes, had missed to consider edge case line#20.

// Your code here along with comments explaining your approach
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s;
    Stack<Integer> minStack;
    int min;
    public MinStack() {
        s = new Stack();
        minStack = new Stack();
        // int top = -1; //maintain the top index as top N/A if stack object
        min = Integer.MAX_VALUE; //inititalize to min int max valuse
        //**Ensure to have a min value added to minStack, when no elements present before
        minStack.push(min);
    }
    
    public void push(int val) {
        // if (val < this.min) this.min = val;
        s.push(val); //increment top idx after inserting 
        if(val<min){
            min = val;
        }
        minStack.push(min);
    }
    
    public void pop() {
        s.pop();
        minStack.pop();
        min = minStack.peek();
        // if(min==s.peek()){         
        //need to delete the top element and update top idx       
        // minStack.pop();
        // }
        
    }
    
    public int top() {
        return s.peek(); //need to return the element at top
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
