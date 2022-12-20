/*

TC: All operations are O(1)
SC: Worst case O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Logic: 
push minimums into the stack to keep track of history of minimums so that as you pop you can rewind. For optimization, 
just push and pop minimums when minimum is changed. Use a variable to keep track of the latest minimum and update that minimum whenever popping
changes the latest minimum.

*/

class MinStack {
    int curMin;
    stack<int> st;
public:
    MinStack() {
        curMin = INT_MAX;
    }
    
    void push(int val) {
        if(val <= curMin)    st.push(curMin), curMin = val;
        st.push(val);
    }
    
    void pop() {
        int curVal = st.top();  st.pop();
        if(curVal == curMin)    curMin = st.top(), st.pop();
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return curMin;
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