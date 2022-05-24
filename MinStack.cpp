//Time Complexity- O(1) for all functions
//Space Complexity- O(n) size of the stack

class MinStack {
public:
    stack<long long> st;
    long long min;
    MinStack() {

    }
    
    void push(int val) {
        if(st.empty()){
            st.push(val);
            min=val;
        }
        else if(val<min){
            long long value=val;
            st.push(2*value-min);
            min=val;
        }
        else{
            st.push(val);
        }
    }
    
    void pop() {
        if(st.top()>min){
            st.pop();
        }
        else{
            min=2*min-st.top();
            st.pop();
        }
    }
    
    int top() {
        if(st.top()>min){
            return st.top();
        }
        else{
            return min;
        }
    }
    
    int getMin() {
        if(st.empty()){
            return -1;
        }
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