// Time Complexity : O(1)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MinStack {
    stack<int> st;
    int min;
public:
    MinStack() {
        min = INT_MAX;
    }
    
    void push(int val) {
        if (val <= min) {
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    void pop() {
        if (st.top() == min) {
            st.pop();
            min= st.top();
        }
        st.pop();
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return min;
    }
};
