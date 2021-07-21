// Time Complexity : O(1) for push, pop, top and getMin
// Space Complexity : O(N) if we push the elements in the decreasing order
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

class MinStack {
    stack<int> minStack;
    int minVal;
public:
    /** initialize your data structure here. */
    MinStack() {
        minVal = INT_MAX;
    }
    
    void push(int val) {
        if(val <= minVal){
            minStack.push(minVal);
            minVal = val;
        }
            
        minStack.push(val);
    }
    
    void pop() {
        if(minStack.top() == minVal){
            minStack.pop();
            minVal = minStack.top();  
        }
        minStack.pop();
    }
    
    int top() {
        return minStack.top();
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