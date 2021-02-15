/*
Time Complexity : For each of the 4 operations the time complexity is O(1)
Space Complexity : O(N)
Did this code successfully run on Leetcode :Yes

Logic: 
While pushing we push twice if the element that we are pushing is less than or equal to the min value stored in min variable.
While popping we check if we are popping the min element, if it is so we pop twice and the second popped value is assigned to min variable.

*/


class MinStack {
private: stack<int>st;
private: int min;
    
public:
    /** initialize your data structure here. */
    MinStack() {
        min = INT_MAX;
    }
    
    void push(int x) {
        if(x<=min){
            st.push(min);
            min = x;
        }
        st.push(x);

    }
    
    void pop() {
        int pop_value = st.top();st.pop();
        if(pop_value == min){
            min = st.top();st.pop();
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
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */