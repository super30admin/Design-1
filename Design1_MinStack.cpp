class MinStack {
    stack<int> st;
    stack<int> minSt;
    int less;
public:
    /** initialize your data structure here. */
    MinStack() {
        less=INT_MAX;
        minSt.push(less);
        
    }
    
    void push(int x) {
        less=min(less,x);
        st.push(x);
        minSt.push(less);
        
       
    }
    
    void pop() {
        st.pop();
        minSt.pop();
        less = minSt.top();
        
    }
    
    int top() {
        return st.top();
        
    }
    
    int getMin() {
        return minSt.top();
        
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