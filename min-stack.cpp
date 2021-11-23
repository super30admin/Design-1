// Time Complexity :T(n)=O(1) all operations
// Space Complexity :S(n) =O(n) 
// Did this code successfully run on Leetcode :Yes



// Your code here along with comments explaining your approach

//used two stacks to implement this one stack always had cuirrent minimum therefore we can obtain O(1) minimum

class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> st;
    stack<int> min;
    int minimum;
    MinStack() {
        minimum=INT_MAX;
        min.push(minimum);
    }
    
    void push(int val) {
        minimum=std::min(minimum,val);
        st.push(val);
        min.push(minimum);
    }
    
    void pop() {
        st.pop();
        min.pop();
        minimum=min.top();
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return minimum;
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
