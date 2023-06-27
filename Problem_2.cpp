/*
// Time Complexity : 
Method push(int val) : O(1) - Explanation - In this implementation it takes constant time to push the item on top of the stack and push whatever is min Value that we have seen till now from the user input. 
    
Method pop() : O(1) - Explanation - We simply pop the top element from the main and auxilary stack. 

Method top() : O(1) - Explanation - Simply peeks the top item currently in the main stack. 

Method getMin() : O(1) - Explanation - We are maintaining an additional Stack which holds the min Value at the top seen till the point of current user input values. We are just returning the value of top from the auxilary value. 

// Space Complexity : O(2 * n) which is equivalent to O(n) including the auxilary stack 'aux'. Because do not exceed the number of items more than n, that is supplied by the user. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
*/
class MinStack {
public:
    stack<int> st; // main stack
    stack<int> aux; // auxilary stack to store the minValue observed till a given point in user Input. 
    MinStack() {
    }
    
    void push(int val) {
        st.push(val);
        if(!aux.empty()){
            int top = aux.top();
            aux.push(min(top, val));
        } else {
            aux.push(val);
        }
        
    }
    
    void pop() {
        if(!st.empty()) {
            st.pop();
            aux.pop();
        }
    }
    
    int top() {
        int res = -1;
        if(!st.empty()) {
            res = st.top();
        }
        return res;
    }
    
    int getMin() {
        int res = 0;
        if(!aux.empty()) {
            res = aux.top();
        }
        return res;
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
