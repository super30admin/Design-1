class MinStack {
public:
    /** initialize your data structure here. */
    int topValue;
    vector<int> minimumValue,stk;
    
    MinStack() 
    {
        topValue=-1;
    }
    
    void push(int x) 
    {
        topValue++;
         stk.push_back(x); 
        if (topValue==0) {
            minimumValue.push_back(x);
        } else {
            minimumValue.push_back(min(minimumValue[topValue-1],x));
        }
    }
    
    void pop() 
    {
        if(topValue==-1)
            return;
        minimumValue.pop_back();
        stk.pop_back();
        topValue--;
    }
    
    int top() 
    {
        return stk.back();
    }
    
    int getMin() {
       return minimumValue.back();
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