// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
#include <iostream>
#include <stack>

using namespace std;

class MinStack {
    stack<int> st;
    stack<int> minSt;
    
    int min;
public:
    MinStack() {
        min = INT_MAX;
        minSt.push(INT_MAX);
        
        
        
    }
    
    void push(int val) {
        if(val<min){
            min=val;
        }
        st.push(val);
        minSt.push(min);
        

        
    }
    
    void pop() {
        
        st.pop();
        minSt.pop();
        min=minSt.top();


        
    }
    
    int top() {
        return st.top();
        
    }
    
    int getMin() {
        return minSt.top();
        
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