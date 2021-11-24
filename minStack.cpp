// Space Complexity - O(n)
// Time Complexity - O(1)
// The code ran successfully on leetcode
// No problems faced while coding this


#include <iostream>
#include<stdio.h>
#include <stack>

using namespace std;

class MinStack {
public:
    stack<int> s;
    int min=INT_MAX;
    MinStack() {
        
    }
    
    void push(int val) {
        if(val<=min)
        {
            s.push(min);
            min=val;
        }
        s.push(val);
    }
    
    void pop() {
        if(s.top() == min)
        {
            s.pop();
            min=s.top();
        }
        s.pop();
    }
    
    int top() {
        return s.top();
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