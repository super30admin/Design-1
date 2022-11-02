// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


class MinStack {
public:
    stack <int> s;
    int min;
    MinStack() {
        min = INT_MAX;
    }
    
    void push(int val) {
    	// if the val is smaller than min, push the previous min to track and update current min
    	// push the val to the stack 
        if(val <= min){
            s.push(min);
            min = val;
        }
        s.push(val);
    }
    
    void pop() {
    	// if the val popped is less than or equal to the min, the min has to be updated to the previous us
    	// pop all the values 
        int top = s.top();
        s.pop();
        if(top <= min){
            min = s.top();
            s.pop();
        }
    }
    
    int top() {
        return(s.top());
    }
    
    int getMin() {
        return (min);
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

// Approach 2: Create another stack to keep track of the min parallel to every element in the stack