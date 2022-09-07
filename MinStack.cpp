class MinStack {
public:
    
    stack<int> Stack;
    stack<int> minStack;
    signed int min;
    
    MinStack() {
        min = INT_MAX;
        minStack.push(min);
    }
    
    void push(int val) {
        Stack.push(val);
        if(val <= min){
            min = val;
        }
        minStack.push(min);
        
    }
    
    void pop() {
        Stack.pop();
        minStack.pop();
        min = minStack.top();
        
    }
    
    int top() {
        return Stack.top();
    }
    
    int getMin() {
        return minStack.top();
        
    }
};

