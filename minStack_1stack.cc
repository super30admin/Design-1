// Time Complexity : Average O(1)
// Space Complexity : Average O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class MinStack {
public:
    /** initialize your data structure here. */
    std::stack<int>* myStack;
    int min = INT_MAX;
    MinStack() {
        myStack = new std::stack<int>();
        myStack->push(min);
    }
    
    void push(int x) {
        if(x <= min){
            myStack->push(min);
            min = x;
        }
        myStack->push(x);
        
    }
    
    void pop() {
        if(myStack->top() == min){
            myStack->pop();
            min = myStack->top();
        }
        myStack->pop();

    }
    
    int top() {
        return myStack->top();
        
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
