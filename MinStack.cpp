#include <bits/stdc++.h>
using namespace std;

class MinStack {
public:
    stack<int> st;
    stack<int> minist;

    MinStack() {}

    void push(int val) {
        st.push(val);
        if (minist.empty() || val <= minist.top()) {
            minist.push(val);
        }
    }

    void pop() {
        if (st.top() == minist.top()) {
            minist.pop();
        }
        st.pop();
    }

    int top() {
        return st.top();
    }

    int getMin() {
        return minist.top();
    }
};

int main() {
    MinStack minStack;
    minStack.push(10);
    minStack.push(5);
    cout << "Top: " << minStack.top() << endl;
    cout << "Min: " << minStack.getMin() << endl;
    minStack.push(3);
    cout << "Top: " << minStack.top() << endl;
    cout << "Min: " << minStack.getMin() << endl;
    minStack.pop();
    cout << "Top: " << minStack.top() << endl;
    cout << "Min: " << minStack.getMin() << endl;
    return 0;
}
