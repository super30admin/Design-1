/*
 * Time Complexity : O(1)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No


 ? Your code here along with comments explaining your approach
   I used a stack to store the value and maintained a min integer variable
   which keeps track of the min value. I'm pushing the min value onto the
   stack only when a new min value is added to the stack to optimize a bit
   on the space.
*/


#include <stack>
#include <climits>

class MinStack {
public:
    std::stack<int> s;
    int min;
    MinStack() : min(INT_MAX) {}

    void push(int val) {
        if (val <= min) {
            s.push(min);
            min = val;
        }
        s.push(val);
    }

    void pop() {
        if (s.top() == min) {
            s.pop();
            if (!s.empty()) {
                min = s.top();
                s.pop();
            } else {
                min = INT_MAX;
            }
        } else {
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */