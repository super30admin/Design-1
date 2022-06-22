// Time Complexity :T(n)=O(1) all operations
// Space Complexity :S(n) =O(n) 
// Did this code successfully run on Leetcode :Yes


// two stacks  implements one stack with O(1) minimum

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
