// Time Complexity : O(1)
// Space Complexity : O(2N) => O(N)
// Did this code successfully run on Leetcode : Yes
// Approach: Created two stacks - one to push original values
// min stack to keep track of min and prev min values.

#include <bits/stdc++.h>
using namespace std;

class MinStack {
public:
    stack<int> st;
    stack<int> minSt;
    int minVal;
    MinStack() {
        minVal = INT_MAX;
        minSt.push(minVal);
    }
    
    void push(int val) {
        minVal = min(minVal,val);
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
