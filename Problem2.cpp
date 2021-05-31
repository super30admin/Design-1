class MinStack {
public:
    /** initialize your data structure here. */
      stack<pair<int, int>> st;
    
    MinStack() {
        
    }
    
    void push(int x) {
        
        if(!st.empty())
        {
            st.push({x, min(x, st.top().second)});
        }
        else
        {
            st.push({x, x});
        }
        
    }
    
    void pop() {
        
        st.pop();
        
    }
    
    int top() {
        
       return st.top().first;
        
    }
    
    int getMin() {
        
        return st.top().second;
        
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