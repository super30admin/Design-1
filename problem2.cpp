# Time Complexity : O(1) for all operations
# Space Complexity : O(n) where n is the number of elements in stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# This code uses 2 stacks: stack s1 that stores all values and s2 which holds the value of the smallest value seen upto this element. 

class MinStack {
    stack<int> s1;
    stack<int> s2;

public:
    MinStack() {
        
    }
    
    void push(int val) {
        s1.push(val);
        s2.push( (!s2.empty() && s2.top()<val) ? s2.top() : val);
    }
    
    void pop() {

        s2.pop();
        s1.pop();

    }
    
    int top() {
        return (s1.top());
    }
    
    int getMin() {
        return (s2.top());
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