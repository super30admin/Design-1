// Time Complexity : Push O(1), Pop O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was assigning value from main stack to the minimum variable, before the popping the current top


// Your code here along with comments explaining your approach
// We maintain a minStack along with a mainStack.
// mainStack works as the normal stack.
// minStack stores the minimum value in the mainStack for every corresponding element in mainStack in the same order.
// While pushing we update the minValue till now (in current stack) and similar with pop.
// While pushing we see if the new value is smaller than minVal and update it, then push this minVal to minStack and original elem to mainStack
// Wihile popping, we pop the element from both main and min stack. Then set current minValue as the top of min stack
// because it is the smalles value for the remaining stack



#include<bits/stdc++.h>
using namespace std;

class MinStack {
public:
    stack<int> mainStack;
    stack<int> minStack;
    int minVal;
    MinStack() {
        minVal = INT_MAX;
    }
    
    void push(int val) {
        mainStack.push(val);
        minVal = min(minVal, val);
        minStack.push(minVal);
    }
    
    void pop() {
        mainStack.pop();
        minStack.pop();

        if(minStack.size() != 0)
            minVal = minStack.top();
        else {
            minVal = INT_MAX;
        }
        
    }
    
    int top() {
        return mainStack.top();
    }
    
    int getMin() {
        return minStack.top();
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