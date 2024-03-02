// Time Complexity : O{1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A

/*
Design MinStack (https://leetcode.com/problems/min-stack/)

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

*/

/*
Code explanation : 
Two vectors are used here. One vector is used as normal stack to store all the data values.
Another vecore min_stack stores the lowest values in stack.

Each data is pushed to dataStack vector.
In min_stack vector, data is pushed only if incoming data is less than or equal to the top
value stored in min_stack.
Also, while poping the data, if top value in min_stack is same as top vale in dataStack then
that value is poped out from both stacks.

This problems can be implemented using only one vector. In that case two values will be
pushed to the vector evrytime. One is data value and another is minimum value.
*/


class MinStack {
    vector <int> dataStack;
    vector <int> min_stack;
public:
    MinStack() {
        min_stack.push_back(INT_MAX);
    }
    
    void push(int val) {
        dataStack.push_back(val);
        if(val <= min_stack.back()){
            min_stack.push_back(val);
        }
    }
    
    void pop() {
        if(dataStack.back() == min_stack.back()){
            min_stack.pop_back();
        }
        dataStack.pop_back();
    }
    
    int top() {
        return dataStack.back();
    }
    
    int getMin() {
        return min_stack.back();
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