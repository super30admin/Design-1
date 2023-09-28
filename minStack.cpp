// Time Complexity : O(1) for all operations
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class MinStack {
    #include <stack>
    using std::stack;
    using namespace std;

    stack<int> st;
    stack<int> minStack;
    int min;
public:
    MinStack() {
        this->min=INT_MAX;
        this->minStack.push(min);
    }
    
    void push(int val) {
        this->min=std::min(min, val);
        this->st.push(val);
        this->minStack.push(min);
    }
    
    void pop() {
        this->st.pop();
        this->minStack.pop();
        this->min=minStack.top();
    }
    
    int top() {
        return this->st.top();
    }
    
    int getMin() {
        return this->minStack.top();
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