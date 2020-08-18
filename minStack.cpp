// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No as of now.


class MinStack {
public:
    /** initialize your data structure here. */
    stack <int> st1;
    int min;
    int popped;
    
    MinStack() {
      
        
    }
    
    void push(int x) {
        if (st1.empty()){
            min  = x;
        }
        if (x<=min){
            st1.push(min);
            min = x;
        }
        st1.push(x);
    }
    
    void pop() {
        popped = st1.top();
        st1.pop();
        if (min == popped){
            min = st1.top();
            st1.pop();
        }
        
    }
    
    int top() {
        return st1.top();
    }
    
    int getMin() {
        return min;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */