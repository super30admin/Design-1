// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


#include <iostream>
#include<stack>

using namespace std;

class MinStack {
public:
    stack<int> s;
    signed int min;
    /** initialize your data structure here. */
    MinStack() {
        min = INT32_MAX;
    }
    
    void push(int val) {
        if(val <= min){
            s.push(min);
            min = val;
        }
        s.push(val);
    }
    
    void pop() {
        signed int val;
        val = s.top();
        s.pop();
        if(val == min){
            min = s.top();
            s.pop();
        }
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return min;
    }
};
int main(){
    MinStack minStack;
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();
    minStack.pop();
    minStack.top();
    minStack.getMin();
    return 0;
}

