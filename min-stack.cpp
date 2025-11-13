// Time Complexity :O(1) for all ops
// Space Complexity :0(n) n elements has to be pushed into this stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


//leetcode(155): https://leetcode.com/problems/min-stack/
#include<iostream>

using namespace std;
class MinStack {

    //creating two stacks: one to hold the og values 
    //and another to hold the min of inserted value in the stack s
private:
    stack<int> s;
    stack<int> min;

public:
    MinStack() { 
        //have to do nothing here for now
    }
    
    void push(int val) {
        //first push the value to main stack
        s.push(val);

        //push into the min stack if the minstack is empty or if the new value is samller than minstack top
        if(min.empty() || val <= min.top()) { min.push(val);}
        else{
            min.push(min.top());// push the top of min as new min again as there is no new min value
        }
    }
    
    void pop() {
        
        s.pop();
        min.pop();
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        //reutrn the min stack top as it maintains the min vals
        return min.top();
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