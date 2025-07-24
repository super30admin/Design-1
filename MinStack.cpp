#include<iostream>
#include<stack>
using namespace std;

class MinStack {
    stack<int> st;
    stack<int> minSt;
    int minVal;

public:
    MinStack() {
        minVal = INT_MAX;
        minSt.push(minVal);
    }

    void push(int val) {
        minVal = std::min(val, minVal);
        st.push(val);
        minSt.push(minVal);
    }

    void pop() {
        st.pop();
        minSt.pop();
        minVal = minSt.top();
    }

    int top() {
        return st.top();
    }

    int getMin() {
        return minVal;
    }
};

int main(){
    
}