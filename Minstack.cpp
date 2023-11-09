class MinStack 
{
  
   vector<int> a;
    int min;
public:
    /** initialize your data structure here. */
    MinStack() {
        min = INT_MAX;
    }
    
    void push(int x)
    {
        if(x <= min) {
            a.push_back(min);
            min = x;
        }
        a.push_back(x);
    }
    
    void pop() 
    {
        int t = a.back(); a.pop_back();
        if (t == min) 
        {
            min = a.back();
            a.pop_back();
        }
    }
    
    int top() 
    {
        return a.back();
    }
    
    int getMin() 
    {
        return min;
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