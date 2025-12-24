//MIN-STACK

class MinStack {
    stack<int> st;
        //actual input stack
        stack<int>minSt;
        int minVal;
        //variable for tracking minimum value
public:
    MinStack() {
        minVal = INT_MAX;
        //in the start, no min value exists so the largest integer is allocated as the minimum
        minSt.push(minVal);
    }
    
    void push(int val) {
        minVal = std::min(val,minVal);
        //existing minVal and val are compared and then the minVal is updated is val < minVal
        st.push(val);
        minSt.push(minVal);
    }
    
    void pop() {
        //one to one mapping for every element pushed in actual stack is done wrt to min stack
        st.pop();
        minSt.pop();
        // when one element is popped from actual stack, the corresponding minVal in also popped from min stack
        minVal = minSt.top();
        // after popping from min stack,the left out value is the new min value
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return minVal;
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