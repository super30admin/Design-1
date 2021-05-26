// Time Complexity : O(1) - All operations
// Space Complexity : O(2*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

class MinStack {
private:
    stack<int> normalStack;
    stack<int> minStack;
    
public:
    /** initialize your data structure here. */
    MinStack() {
        minStack.push(INT_MAX);
    }
    
    void push(int val) {
        
        normalStack.push(val);
        
        if(val <= minStack.top())
        {
            minStack.push(val);
        }
        
        return;
    }
    
    void pop() {
        int val = normalStack.top();
        
        normalStack.pop();
        
        if(val == minStack.top())
        {
            minStack.pop();
        }
    }
    
    int top() {
        
        return normalStack.top();
    }
    
    int getMin() {
        
        return minStack.top();
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