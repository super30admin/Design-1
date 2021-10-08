// Time Complexity : O(1)
// Space Complexity : O(n) (specifically Space Complexity is O(2 * n) as we store 2 value for one pushed value)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include <iostream>
#include <stack> 
#include <utility>
using namespace std;

class MinStack {
    stack<pair<int,int> > minStack;
    
public:
    MinStack() {
        
    }
    
    void push(int val) {
        if (minStack.empty()) {
            minStack.push({val,val});
        }
        else {
            minStack.push({val, min(val,minStack.top().second)});
        }
    }
    
    void pop() {
        if (!minStack.empty()) {
            minStack.pop();     
        }
    }
    
    int top() {
        return minStack.top().first;
    }
    
    int getMin() {
        return minStack.top().second;
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

int main() 
{
    MinStack minStack;
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    cout << minStack.getMin() << endl;// return -3
    minStack.pop();
    cout << minStack.top() << endl;   // return 0
    cout << minStack.getMin() << endl;
    return 0;
}