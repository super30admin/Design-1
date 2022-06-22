Design MinStack (https://leetcode.com/problems/min-stack/)

//First Solution with 2 stacks
// Time Complexity : O(1) -> all constant time operations 
// Space Complexity : O(n) for normal stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {
public:
    stack<int> s;
    int min1;
    MinStack() {
        min1 = INT_MAX;
        
    }
    
    void push(int val) {
        // condition to check if the incomung value is less than min
        // if yes then push it on the stack and then update the min
        if(val <= min1){  
            s.push(min1);
            min1 = val;
        }
        s.push(val);
    }
    
    void pop() {
       int pop1 = s.top();
       s.pop();
        //if the element you popped is the min element
        // you will need to set the minimum to next popped element
       if(min1 == pop1){
           int pop2 = s.top();
           min1 = pop2;
           s.pop();
       }
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return min1;
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


//Second Solution with 2 stacks
// Time Complexity : O(1) -> all constant time operations 
// Space Complexity : O(n) for normal stack + O(n) for minStack = O(2n) which is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinStack {
public:
    stack<int> s;
    stack<int> minStack;
    int min1;
    MinStack() {
        min1 = INT_MAX;
        minStack.push(min1);
    }
    
    void push(int val) {
        min1 = min(val, min1); 
        s.push(val);
        minStack.push(min1);
    }
    
    void pop() {
        s.pop();
        minStack.pop();
        min1 = minStack.top();
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return min1;
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


