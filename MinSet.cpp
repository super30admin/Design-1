#include <iostream>
#include <stack>

using namespace std;

// Time Complexity : O(1) for all the functions
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MinStack {
public:
    stack<int> s;
    int minVal;
    MinStack() {
        minVal = INT_MAX;
    }

    void push(int val) {
        // comparing and pushing the current min, so  we pop, we have 2nd min
        if(val <= minVal){
            s.push(minVal);
            minVal = val;
        }
        // Normal push
        s.push(val);
    }

    void pop() {
        int t = s.top();
        // normal pop
        s.pop();
        // popping the 2nd min too, but we stored that val in min before popping
        if(t == minVal){
            minVal = s.top();
            s.pop();
        }
    }

    int top() {
        return s.top();
    }

    int getMin() {
        return minVal;
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