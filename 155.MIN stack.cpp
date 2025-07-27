class MinStack {
    stack<int>st;  
    int min ;
public:
    MinStack() {
        min = INT_MAX; 
    }
    
    void push(int val) { // if val is less than min push pre min and val else only val to keep track of old min in case of pop
    if(val<=min)
    {
       st.push(min);
       min =val;
    }
    st.push(val);
    }
    
    void pop() { // if min equal to top them pop the ele and then update new min and pop again 
        if(st.top()==min)
        { 
            st.pop();
            min = st.top();
            st.pop();
        }
        else
        st.pop();
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return min;
        
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