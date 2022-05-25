
// Time Complexity : push O(1) , pop O(1), top O(1), getMin O(1)
// Space Complexity : O(n) worst case
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
// 2 stack approach with minstack array only getting filled when necessary. Not one to one mapping.!!

class MinStack {
    
   stack<int>actstack;
   stack<int>minstack;
    
public:
    MinStack() {
        
    }
    
    void push(int val) {
        actstack.push(val);
        if( minstack.size() ){
            if( val <= minstack.top() ) {
                minstack.push(val);
            }
        } else {
          minstack.push(val);  
        }
    }
    
    void pop() {
        if( actstack.size() ){
            int elem = actstack.top();
            actstack.pop();
            if( minstack.top() == elem ){
                minstack.pop();
            }
        } else {
            // no elem present
            return;
        }
    }
    int top() {
        if(actstack.size() ) {
           return actstack.top();
        } else {
            // no elem
            return INT_MIN;
        }
    }
    
    int getMin() {
        if(minstack.size() ) {
           return minstack.top();
        } else {
            // no elem
            return INT_MIN;
        }
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
