// Time Complexity : O(1) for all operations.
// Space Complexity : O(n) , where n is the number of elements pushed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// A min stack is created using single stack and
// a min variable to keep a track of the min value in stack always.
// When we push a value into the stack we check if it is less than the current min stored.
// If its less we push the current min into the stack first and then the value. Also, update the new min with the value
// If greater we just push the value only.
// If we pop an element and if it is equal to the min, we pop it and store the previous min as the current min and then pop it as well.
import java.util.Stack;
class MinStack {

    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(min >= val){
            st.push(min);
            min = val;
        }
        st.push(val);
    }

    public void pop() {
        if(st.pop() == min){
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
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */