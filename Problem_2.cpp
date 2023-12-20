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

#include <iostream>
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

int main() {
    // Create a MinStack object
    MinStack* minStack = new MinStack();

    // Test case 1: Push elements onto the stack
    minStack->push(-2);
    minStack->push(0);
    minStack->push(-3);
    std::cout << "Test Case 1 - Get Min: " << minStack->getMin() << std::endl; // Expected output: -3

    // Test case 2: Pop the top element
    minStack->pop();
    std::cout << "Test Case 2 - Top element: " << minStack->top() << std::endl; // Expected output: 0
    std::cout << "Test Case 2 - Get Min: " << minStack->getMin() << std::endl; // Expected output: -2

    // Test case 3: Push another element
    minStack->push(-1);
    std::cout << "Test Case 3 - Top element: " << minStack->top() << std::endl; // Expected output: -1
    std::cout << "Test Case 3 - Get Min: " << minStack->getMin() << std::endl; // Expected output: -2

    // Clean up
    delete minStack;

    return 0;
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */