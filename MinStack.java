// Time Complexity : O(1) 
/* Since updating the minimum element at every addition of new elemnet and keeping track of minimum element at every element, the time complexity is O(1) */
// Space Complexity : O(n)
/* Since an Array is maintained to keep track of the minimum element at every additon of new element, the space complexity is O(n) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinStack {

    /** initialize your data structure here. */
    // Used Stack Data structure and array as element of stack

    Stack<int[]> st;
    public MinStack() {
        st = new Stack();
    }

    // Push the new element as well as the minimum element by comparing all the elements so far in the stack 
    // including the new element as array[0] and array[1] appropriately
    public void push(int x) {
        if(st.isEmpty()) st.push(new int[]{x,x});
        else st.push(new int[]{x,Math.min(x,st.peek()[1])});
    }

    // Remove the top element in the stack
    public void pop() {
        st.pop();
    }

    // @return the peek element i.e. array at it's 0th index which has the top element
    public int top() {
        return st.peek()[0];
    }

    // @return the minimum element i.e. array at it's 1st index which has the compared/ updated
    // min element at every addition of new element
    public int getMin() {
        return st.peek()[1];
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
