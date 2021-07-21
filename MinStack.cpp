//Problem-2
//Code is in c++
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Want to decrease Space Complexity
#include <stack>

class MinStack {
public:
    /** initialize your data structure here. */
    stack<int>s1;
    stack<int>s2;
    MinStack() {
    }
    
    void push(int val) {
        s1.push(val);
        if(s2.empty()){
            s2.push(val);
            return;
        }
        if(s2.top()>=val){
            s2.push(val);
            return;
        }
        s2.push(s2.top());
    }
    
    void pop() {
        s1.pop();
        s2.pop();
    }
    
    int top() {
        return s1.top();
    }
    
    int getMin() {
        return s2.top();
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