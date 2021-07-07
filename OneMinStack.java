// Time Complexity : push,pop,top and getMin - all functions have O(1) time complexity
// Space Complexity : As we use two stacks, space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class OneMinStack {
    Stack<Integer> st = new Stack<>();

    int global_minimum=Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        st.push(global_minimum);
    }

    public void push(int x) {
        //if the incoming element  < minimum, push minimum element and then the incoming element
        //Set the new minimum element
        if(x<global_minimum){
            st.push(global_minimum);
            global_minimum = x;
        }

        st.push(x);

    }

    public void pop() {

        //When you pop an element out of stack, if the popped element is the global minimum, pop the next element
        // and set that to the globla minimum.
        if(global_minimum == st.pop()){

            global_minimum = st.pop();
        }



    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return global_minimum;
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