// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Got error when used INT_MIN 


// Your code here along with comments explaining your approach:
// 1. Used 2 stacks to store minimum and values. 
// 2. Pop minimum only when current value to pop is minimum.

class MinStack {
public:
    stack<int> s,s1;
    int min;
    MinStack() {
    }
    
    void push(int val) {
        s.push(val);
        if (s1.empty() || val <= s1.top()) {
            s1.push(val);
        }
    }
    
    void pop() {
        if(s1.top() == s.top()){
            s1.pop();
        }
        s.pop();
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return s1.top();
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