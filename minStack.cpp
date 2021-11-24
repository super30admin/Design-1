// Time Complexity : O(1) for all operations
// Space Complexity : O(N) for storing data
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class MinStack 
{
    stack<pair<int,int>>s;
    
public:
    MinStack() 
    {
        
    }
    
    void push(int val) 
    {
        if(s.empty())
            s.push(make_pair(val,val));
        else
        {
            pair<int,int> topEle = s.top();
        
            if(topEle.second>val)
                s.push(make_pair(val,val));
            else
                s.push(make_pair(val,topEle.second));
        }
    }
    
    void pop() 
    {
        if(!s.empty())
            s.pop();
    }
    
    int top() 
    {
        if(s.empty())
            return NULL;
        
        pair<int,int> topEle = s.top();
        return topEle.first;
    }
    
    int getMin() 
    {
        if(!s.empty())
        {
            pair<int,int> topEle = s.top();
            return topEle.second;
        }
        return NULL;
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