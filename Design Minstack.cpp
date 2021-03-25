// Time Complexity: O(1)
// Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> s;
    stack<int> min_stack;
    MinStack() {
        
    }
    
    void push(int val) {
        if(min_stack.empty()||val<=min_stack.top()){
            min_stack.push(val);
        }
        s.push(val);
    }
    
    void pop() {
        if(min_stack.top()==s.top()){
            min_stack.pop();
        }
        s.pop();
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return min_stack.top();
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
