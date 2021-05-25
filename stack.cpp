// Time Complexity : run time 24 ms
// Space Complexity : space:  16.5 MB
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinStack {
public:
    /** initialize your data structure here. */

    stack <int> st;       //Created original stack
    stack <int> newst;		// new stack is created for storing smaller values





    void push(int val) {

        st.push(val);

        if(!newst.empty() && newst.top() < val)
            newst.push(newst.top());        // New value is comared with valued stacked before
        else				   //  if the value is smaller add to new stack else add the previous stacked value
            newst.push(val);

    }

    void pop() {


          st.pop();
         newst.pop();
    }

    int top() {

        return  st.top(); // returns value from the original stack

    }

    int getMin() {

       return newst.top(); // smaller value will be checked in newst as it will only store the smaller values.

    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
