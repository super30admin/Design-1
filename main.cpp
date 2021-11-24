#include <stdio.h>
#include "stack"

using namespace std;
class MinStack {
public:
    std::stack<int> s;
    stack<int> m;
    MinStack() {
    }

    void push(int val) {
        s.push(val);
        if(m.empty() || val <= m.top()){
            m.push(val);
        }
    }

    void pop() {
        int temp = s.top();
        s.pop();
        if(temp == m.top()){
            m.pop();
        }
    }

    int top() {
        if(!s.empty()){
            return s.top();
        }
        return -1;
    }

    int getMin() {
        if(!m.empty()){
            return m.top();
        }
        return -1;
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