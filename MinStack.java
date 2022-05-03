// Time Complexity :  O(1) for push, pop, top and getMin
// Space Complexity : O(2n) in worst case (elements sorted in descending order) and O(n) in average case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Problem 2
class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
        st=new Stack<>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<=min){
            //Store prev min, if min changes
            st.push(min);
            min=val;
        }
        st.push(val);
    }
    
    public void pop() {
        if(min==st.pop()){
            min=st.pop();
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
