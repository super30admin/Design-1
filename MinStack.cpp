// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach

/* Maintain min variable which returns current min value.  
 * For push operation :- If min is greate or equal to new value then push the current min on stack, assign new value to min and push new value on stack.
 * For pop operation :- Pop the top element, if top element is same as min element then pop again and assign removed element to min. 
 */

class MinStack {
public:
    stack<int> st;
    int min; 
    
    MinStack() {
        min = INT_MAX;
    }
    
    void push(int val) {
        
        if (min >= val)
        {
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    void pop() {
        int stack_element = st.top();
        st.pop();
        
        if (stack_element == min)
        {
            min = st.top();
            st.pop();
        }
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return min;
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