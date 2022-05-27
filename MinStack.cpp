// Approach 1 - Using 2 stacks with one-to-one mapping for each element in stack 1 to the current minimum value in stack 2.
// Time Complexity -- push(), pop(), top() and getMin() are O(1)
// Space Complexity - O(N) - depends on the number of elements being added to the stacks
// Problems Faced - No!
// It runs on Leetcode

class MinStack {
    
public:
    stack<int> stack1;
    stack<int> stack2;
    int m;
    MinStack() {
        m = INT_MAX;
        stack2.push(m);
    }
    
    void push(int val) {
        m = min(m, val);
        stack1.push(val);
        stack2.push(m);
    }
    
    void pop() {
        stack1.pop();
        stack2.pop();
        m = stack2.top();
    }
    
    int top() {
        return stack1.top();
    }
    
    int getMin() {
        return stack2.top();
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


// Approach 2 - Algorithm discussed in class.
// Time Complexity -- push(), pop(), top() and getMin() are O(1)
// Space Complexity - O(N) - depends on the number of elements being added to the stack.
// Problems Faced - No!
// It runs on Leetcode

class MinStack {
public:
    stack<int> stack1;
    int currMin;
    MinStack() {
        currMin = INT_MAX;
    }
    
    void push(int val) {
        if (currMin >= val){
            stack1.push(currMin);
            currMin = val;
        }
        stack1.push(val);
    }
    
    void pop() {
        if(currMin == stack1.top()){
            stack1.pop();
            currMin = stack1.top();
            stack1.pop();
        }
        else
            stack1.pop();
    }
    
    int top() {
        return stack1.top();
    }
    
    int getMin() {
        return currMin;
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
