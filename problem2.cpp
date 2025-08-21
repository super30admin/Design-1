// Time Complexity : O(1) for push(), pop(), top(), getMin()
// Space Complexity : O(1) for user-facing functions, but O(n) overall.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We use a 2 stack approach, where the mainStack contains all elements the user pushes, the trackMin stack is used to track min at all times. 
// We push to the trackMin stack if its empty OR if the new value being pushed into the mainStack is <= the top of the trackMin stack (indicating we have a new minimum element).
// For pop, we check if the element being popped from the mainStack is == top of trackMin, if yes -> we pop from both stacks. For top, we return mainStack.top(), for getMin(), we return trackMin.top() 

#include <stack>
#include <iostream>
using namespace std;

class MinStack {
private:
    stack<int> mainStack;
    stack<int> trackMin;

public: 
    MinStack() = default; // default ctor
    
    void push(int val) {
        mainStack.push(val);
        if(trackMin.empty() || val <= trackMin.top()){
            trackMin.push(val);
        }
    }
    
    void pop() {
        if(mainStack.empty()) {
            throw underflow_error("Pop on empty minstack!");
        };
        if(mainStack.top() == trackMin.top()){
            trackMin.pop();
        }
        mainStack.pop();
    }
    
    int top() {
        if(mainStack.empty()) {
            throw underflow_error("Top on empty minstack!");
        }
        return mainStack.top();
    }
    
    int getMin() {
        if(mainStack.empty()) {
            throw underflow_error("getMin on empty minstack!");
        }
        return trackMin.top();
    }
};

int main() {
    MinStack minstack;
    // minstack.top(); // commented this out since leetcode guarantees stack operations will be performed on non empty stack
    // minstack.pop();
    minstack.push(2);
    cout<<"Pushing 2..."<<endl;
    cout<<"Min: "<< minstack.getMin() <<endl;
    minstack.push(1);
    cout<<"Pushing 1..."<<endl;
    cout<<"Top: "<< minstack.top() <<endl;
    cout<<"Min: "<< minstack.getMin() <<endl;
    minstack.pop();
    cout<<"Popped 1..."<<endl;
    cout<<"Min: "<< minstack.getMin() <<endl;
 }