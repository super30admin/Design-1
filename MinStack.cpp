#include <stack>
#include <climits>
using namespace std;

class MinStack {
private:
    stack<int> st;
    int minNum = INT_MAX;
public:
    MinStack() {   
    }
    
    void push(int val) {
        if (val <= minNum) {
            st.push(minNum);
            minNum = val;
        }
        st.push(val);
    }
    
    void pop() {
        int val = st.top();
        st.pop();
        if (val == minNum) {
            minNum = st.top();
            st.pop();
        }
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return minNum;
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