// Time Complexity                                  : PUSH    - O(1)
//                                                    POP     - O(1)
//                                                    TOP     - O(1)
//                                                    GETMIN  - O(1)
// 
// Space Complexity                                 : O(N) = O(N) - storing key, value and next for each value.
// Did this code successfully run on Leetcode       : Yes.
// Any problem you faced while coding this          : No.

#include<bits/stdc++.h>
using namespace std;

class MinStack {
public:
    stack<int> st;
    int mn;
    MinStack() {
        
    }
    
    void push(int val) {
        
        if(st.empty()) {
            st.push(INT_MAX);
            mn = val;
            st.push(val);
        } else {
            if(val <= mn) {
                st.push(mn);
                mn = val;
            }
            st.push(val);
        }
    }
    
    void pop() {
        int m = st.top();
        if(m == mn) {
            st.pop();
            mn = st.top();
        }
        st.pop();  
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return mn;
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