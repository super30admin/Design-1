#include <stack>
class MinStack {

// Time Complexity : O(1)
// Space Complexity : O(n)    
public:
    stack<int> stack1;
    stack<int> minStack;
    MinStack() {
        
    }
    
    void push(int val) {
       stack1.push(val);
       if(minStack.empty() || minStack.top() >= val){
           minStack.push(val);
       } 
    }
    
    void pop() {
        if(!stack1.empty() && !minStack.empty()  && stack1.top()==minStack.top()){
            minStack.pop();
        }
        stack1.pop();
    }
    
    int top() {
        return !stack1.empty()? stack1.top(): -1;
    }
    
    int getMin() {
       return !minStack.empty()?minStack.top():-1;
    }
};