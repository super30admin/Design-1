class MinStack {
public:
    /** initialize your data structure here. */
    int topValue; //top value will top to the top element 
    vector<int> minimumValue,stk; //2 vector initialized one for normal coding and another for keeping the min value
    
    MinStack() 
    {
        topValue=-1; //initiallize the value to -1
    }
    
    void push(int x) 
    {
        topValue++; //while pushing the value increment to -1
         stk.push_back(x);  // push the value to the normal stack
        if (topValue==0) { // this means it is the first insertion
            minimumValue.push_back(x); 
        } else {
            minimumValue.push_back(min(minimumValue[topValue-1],x)); //compare the minimum value in the top of the stack and the current value
        }
    }
    
    void pop() 
    {
        if(topValue==-1) // empty stack condition
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