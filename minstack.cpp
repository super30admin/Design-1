class MinStack {
public:
    /** initialize your data structure here. */
    
    
        stack<int>s;
        stack<int>min; 
    void push(int x) {
        if(s.empty())
        {
            s.push(x);
            min.push(x);
            return;
        }            
        else
        {
            if(x<=min.top())
            {
                s.push(x);
                min.push(x);
            }
            else
            {
                s.push(x);
            }
            return;
        }
    }
    
    void pop() {
        if(!s.empty())
        {
            if(s.top()==min.top())
            {
                min.pop();
            }
            s.pop();
        }
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return min.top();
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