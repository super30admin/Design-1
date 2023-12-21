// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
// Created a single stack to store both the min value and elemets in each iteration.
#include <iostream>
#include <limits>
#include <stack>

class MinStack {
public:
    int minVal;
    std::stack<int> stack;
    MinStack() {
        minVal = INT_MAX;
    }
    
    void push(int val) {
        // pushing into stack if given value is <= minVal. We handle duplicate elements too"
        if(val <= minVal)
        {
            stack.push(minVal);
            minVal = val;
        }  
        stack.push(val);
        return;
    }
    
    void pop() {
        // We remove two values if top is also the min value.
        int topVal = stack.top();
        stack.pop();
        if(topVal == minVal)
        {
            topVal = stack.top();
            stack.pop();
            minVal = topVal;
        }
        return;
    }
    
    int top() {
        return stack.top();
    }
    
    int getMin() {
        return minVal;
    }
};