// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//using 2 stacks, pushing minvalue into minstack on each push

#include <iostream>
#include <stack>
#include <climits>  
#include <algorithm> 

class MinStack {
    std::stack<int> st;     
    std::stack<int> minSt;  
    int minVal;

public:
    MinStack() {
        minVal = INT_MAX;
        minSt.push(minVal);  
    }

    void push(int val) {
        minVal = std::min(val, minVal);  
        st.push(val);
        minSt.push(minVal);              
    }

    void pop() {
        st.pop();
        minSt.pop();
        minVal = minSt.top();            
    }

    int top() {
        return st.top();
    }

    int getMin() {
        return minVal;
    }
};
