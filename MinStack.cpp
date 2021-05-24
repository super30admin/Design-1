class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> s, minS;
    MinStack() {
        
    }
    
    void push(int val) {
        s.push(val);
        //Push in minS only if curr element is smaller than the val on top of minS
        if(minS.empty() || val <= minS.top()) {
            minS.push(val);
        }
    }
    
    void pop() {
        //pop val from minS only if it is same val as that the one which is being popped from main stack
        if(s.top() == minS.top()) {
            minS.pop();
        }
        s.pop();
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return minS.top();
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