/* Exercise 2: Design MinStack

Design a Data Structure SpecialStack that supports all the stack operations 
like push(), pop(), isEmpty(), isFull() and an additional operation getMin() 
which should return minimum element from the SpecialStack. All these operations 
of SpecialStack must be O(1). To implement SpecialStack, you should only use 
standard Stack data structure and no other data structure like arrays, list, .. etc. 
*/

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//this approach is implemented using one stack

class MinStack {
    Stack<Integer> st = new Stack<>();
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() { 
    }
    
    public void push(int x) {
        if(x <= min){
            st.push(min);
            min = x;
        }
        st.push(x);
    }
    
    public void pop() {
        if(min == st.pop()){
            min = st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
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