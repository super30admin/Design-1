class MinStack
{
public:
    stack<int> st;
    stack<int> minStack;
    int minValue;
    MinStack()
    {
        minValue = INT_MAX;
        minStack.push(minValue);
    }

    void push(int val)
    {
        st.push(val);
        minValue = std::min(val, minValue);
        minStack.push(minValue);
    }

    void pop()
    {

        st.pop();
        minStack.pop();
        minValue = minStack.top();
    }

    int top()
    {
        return st.top();
    }

    int getMin()
    {
        return minStack.top();
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