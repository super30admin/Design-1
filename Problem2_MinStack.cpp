// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Did a logic error which caused the the stack to throw undefined error everytime it was empty

class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> s;
    stack<int> ms;
    
    void push(int x) {
        if(ms.empty()||x<=ms.top()){
            ms.push(x);
        }
        s.push(x);
    }
    
    void pop() {
        if(s.top()==ms.top()){
            ms.pop();
        }
        s.pop();
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return ms.top();
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