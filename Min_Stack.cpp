// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Needed to remember the syntax's.

#include <vector>
class MinStack {
public:
vector<pair<int,int>> stack;
    MinStack() {

    }
    
    void push(int val) {
    if(stack.empty())stack.push_back({val,val});
    else stack.push_back({val,min(stack.back().second,val)});
    }
    
    void pop() {
        stack.pop_back();
    }
    
    int top() {
        return stack.back().first;
    }
    
    int getMin() {
        return stack.back().second;
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
