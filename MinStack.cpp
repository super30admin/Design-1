#include<iostream>
#include<stack>

using namespace std;

class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> st;
    stack<int> min;
    int minimum;
    MinStack() {
        minimum=INT_MAX;
        min.push(minimum);
    }
    
    void push(int val) {
        minimum=std::min(minimum,val);
        st.push(val);
        min.push(minimum);
    }
    
    void pop() {
        st.pop();
        min.pop();
        minimum=min.top();
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return minimum;
    }
};
