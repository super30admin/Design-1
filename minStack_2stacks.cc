// Time Complexity : O(1)
// Space Complexity : O(n) because we ignore constants 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class MinStack {
public:
    std::stack<int>* stack1;
    std::stack<int>* minStack;
    int min = INT_MAX;
    /** initialize your data structure here. */
    MinStack() {
        stack1 = new std::stack<int>();
        minStack = new std::stack<int>();
        minStack->push(min);
    }
    
    void push(int x) {
        stack1->push(x);
        if(x <= min){
            min = x;
        }
        minStack->push(min);
    }
    
    void pop() {
        stack1->pop();
        minStack->pop();
        min = minStack->top();
    }
    
    int top() {
        return stack1->top();
    }
    
    int getMin() {
        return min;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
