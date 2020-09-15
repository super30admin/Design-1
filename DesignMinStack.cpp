// Time Complexity : O(1)
// Space Complexity :O(N) implemented 2 stacks 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
class MinStack {
public:
    /** initialize your data structure here. */
    int mini;
    stack<int> stk; //this is the main stack 
    stack<int> min_stk; //this stack will contain the min values
    
    MinStack() 
    {
        
    }
    
    void push(int x) 
    {
        stk.push(x);
        if(min_stk.empty() || x<=min_stk.top())
        min_stk.push(x);
    }
    
    void pop() 
    {
        int x=stk.top();
        stk.pop();
    
        if(x==min_stk.top())
            min_stk.pop();
    }
    
    int top() 
    {
        return stk.top();
    }
    
    int getMin() {
       return min_stk.top();
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
// Your code here along with comments explaining your approach
